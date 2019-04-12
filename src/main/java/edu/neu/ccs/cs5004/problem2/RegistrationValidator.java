package edu.neu.ccs.cs5004.problem2;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * This class checks ProspectiveDrivers and decides if they meet the criteria for becoming an active
 * driver for our service. If ProspectiveDrivers meets all criteria driver and vehicle combination
 * get entered into the pool containing all active drivers. A duplicate application will not update
 * the system.
 */
public class RegistrationValidator {

  private Map<Driver, Set<VehicleInformation>> acceptedDrivers;

  private List<String> acceptedCountries;

  private static final Integer MIN_DRIVER_AGE = 21;
  private static final Integer MIN_LICENSE_AGE = 6;
  private static final Integer MAX_VEHICLE_AGE = 20;
  private static final Integer MIN_TIME_PASSED_SINCE_INCIDENT = 6;


  /**
   * Creates a new RegistrationValidator with an empty active driver pool.
   */
  public RegistrationValidator() {
    this.acceptedDrivers = new HashMap<>();
    this.acceptedCountries = new ArrayList<>();
    this.acceptedCountries.add("USA");
  }

  /**
   * If the applicant meets all company criteria they are added to the pool of existing drivers and
   * the method returns true. Otherwise no change is made and mathod returns false.
   *
   * @param applicant prospective driver to add
   * @return true if successfully added to the
   */
  public boolean addProspectiveDriver(ProspectiveDriver applicant) {
    boolean isCorrectAge = checkDriverAge(applicant);
    boolean hasValidLicense = checkDriversLicense(applicant);
    boolean hasValidVehicle = checkVehicle(applicant);
    boolean hasValidInsurance = checkInsurance(applicant);
    boolean hasValidDrivingHistory = applicant.getDriverHistory().containsDisqualifyingViolation();
    boolean hasValidVehicleHistory = checkVehicleHistory(applicant);
    boolean isValidDriver = isCorrectAge && hasValidLicense && hasValidVehicle && hasValidInsurance
        && hasValidDrivingHistory && hasValidVehicleHistory;
    if (isValidDriver && addDriver(applicant)) {
      System.out.println("Driver successfully added to the driver pool");
      return true;
    } else {
      System.out.println("Driver not accepted");
      return false;
    }
  }

  /**
   * Attempts to add a new mapping of a driver and vehicle to the system. Returns false if no update
   * is made.
   *
   * @param applicant the driver to add
   * @return true if successfully added
   */
  private boolean addDriver(ProspectiveDriver applicant) {
    Driver accepted = applicant.getAsDriver();
    if (!acceptedDrivers.containsKey(accepted)) {
      acceptedDrivers.put(accepted, new HashSet<>());
    }
    return acceptedDrivers.get(accepted).add(applicant.getVehicle());
  }

  /**
   * Checks to make sure there are no accidents of moving violations in the past 6 months.
   *
   * @param applicant the applicant whose history to check
   * @return true if there are no incidents within past 12 months
   */
  private boolean checkVehicleHistory(ProspectiveDriver applicant) {
    VehicleHistory vehHistory = applicant.getVehicleHistory();
    List<AbstractViolation> violations = vehHistory.getViolations();
    List<Accident> accidents = vehHistory.getAccidents();
    Calendar calendar = Calendar.getInstance();
    //Set calendar to 6 months ago
    calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - MIN_TIME_PASSED_SINCE_INCIDENT);
    boolean isValid = true;
    for (AbstractViolation viol : violations) {
      if (viol.violationType == ViolationType.MOVING
          && calendar.getTime().before(viol.dateOfViolation)) {
        isValid = false;
      }
    }
    for (Accident accident : accidents) {
      if (calendar.getTime().before(accident.getDate())) {
        isValid = false;
      }
    }
    return isValid;
  }

  /**
   * Checks to see if the applicant's Insurance is not expired and the name matches the
   * application.
   *
   * @param applicant the applicant to check
   * @return true if the name matches the insurance and it's not expired
   */
  private boolean checkInsurance(ProspectiveDriver applicant) {
    boolean isOfficialOwner = applicant.getName().equals(applicant.getInsurance().getName());
    boolean isSecondary = applicant.getInsurance().getOthersCoveredDrivers()
        .contains(applicant.getName());
    Calendar calendarExpire = Calendar.getInstance();
    boolean isNotExpired = calendarExpire.getTime()
        .before(applicant.getInsurance().getExpireDate());
    return (isOfficialOwner || isSecondary) && isNotExpired;
  }

  /**
   * Checks if the applicant's vehicle is less than 20 years old.
   *
   * @param applicant the applicant to check
   * @return true if vehicle is less than 20 years old
   */
  private boolean checkVehicle(ProspectiveDriver applicant) {
    Calendar calendar = Calendar.getInstance();
    Integer currentYear = calendar.get(Calendar.YEAR);
    return (currentYear - applicant.getVehicle().getYear()) < MAX_VEHICLE_AGE;

  }

  /**
   * Checks to see if the driver is over the minimum driver age.
   *
   * @param applicant the driver to check
   * @return true if birth date is older than minimum driver age
   */
  private boolean checkDriverAge(ProspectiveDriver applicant) {
    Calendar calendar = Calendar.getInstance();
    //Set date to 21 years ago
    calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - MIN_DRIVER_AGE);
    return calendar.getTime().after(applicant.getBirthDate());
  }

  /**
   * Checks that the driver has a valid drivers license. The name must match the application, the
   * birth dates must match, it must be issues by a country in the list of valid issuing countries,
   * the license must not be expired, and it must be more than 6 months old.
   *
   * @param applicant the applicant to check
   * @return true if the license is valid
   */
  private boolean checkDriversLicense(ProspectiveDriver applicant) {
    boolean validName = applicant.getName().equals(applicant.getLicense().getName());
    boolean validBirthDate = applicant.getBirthDate().equals(applicant.getLicense().getBirthDate());
    boolean issuedByValidCountry = acceptedCountries
        .contains(applicant.getLicense().getIssuingCountry());
    return validName && validBirthDate && issuedByValidCountry
        && checkDriversLicenseDates(applicant);

  }

  /**
   * Returns true if the dates of the applicants license are valid. The license must not be expired
   * and must be more than the minimum license age.
   */
  private boolean checkDriversLicenseDates(ProspectiveDriver applicant) {
    Calendar calendarIssue = Calendar.getInstance();
    calendarIssue.set(Calendar.MONTH, calendarIssue.get(Calendar.MONTH) - MIN_LICENSE_AGE);
    boolean validIssueDate = calendarIssue.getTime().after(applicant.getLicense().getIssueDate());
    Calendar calendarExpire = Calendar.getInstance();
    boolean isNotExpired = calendarExpire.getTime().before(applicant.getLicense().getExpireDate());
    return isNotExpired && validIssueDate;
  }

  /**
   * Returns the collection of accepted drivers. Each key is an accepted driver and each value is a
   * collection of all vehicles they are approved to drive.
   *
   * @return a collection of accepted drivers
   */
  public Map<Driver, Set<VehicleInformation>> getAcceptedDrivers() {
    return this.acceptedDrivers;
  }

  /**
   * Returns true if this equals other.
   *
   * @param other the object to compare
   * @return true if the objects are equal
   */
  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    }
    if (other == null || getClass() != other.getClass()) {
      return false;
    }
    RegistrationValidator that = (RegistrationValidator) other;
    return Objects.equals(acceptedDrivers, that.acceptedDrivers)
        && Objects.equals(acceptedCountries, that.acceptedCountries);
  }

  /**
   * Returns a numeric representation of the object.
   *
   * @return the numeric representation of the object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(acceptedDrivers, acceptedCountries);
  }

  /**
   * Returns  a string representation of the object.
   *
   * @return a string representing the object
   */
  @Override
  public String toString() {
    return "RegistrationValidator{"
        + "acceptedDrivers=" + acceptedDrivers
        + ", acceptedCountries=" + acceptedCountries
        + '}';
  }
}
