package com.techelevator;

import java.math.BigDecimal;
import java.util.*;

public class App {

    // The regex string to split the Strings in the dataset.
    private static final String FIELD_DELIMITER = "\\|";

    private static final int TITLE_FIELD = 0;
    private static final int AUTHOR_FIELD = 1;
    private static final int PUBLISHED_YEAR_FIELD = 2;
    private static final int PRICE_FIELD = 3;

    private final Scanner keyboard = new Scanner(System.in);

    private List<String> titles = new ArrayList<>();
    private List<String> authors = new ArrayList<>();
    private List<Integer> publishedYears = new ArrayList<>();
    private List<BigDecimal> prices = new ArrayList<>();

    public static void main(String[] args) {

        App app = new App();
        app.loadData();
        app.run();

    }

    private void loadData() {

        String[] dataset = Dataset.load();

        /*
         Requirement: 1
         Populate the instance variables `titles`, `authors`, `publishedYears`,
         and `prices` by splitting each string in the `dataset` array and adding
         the individual fields to the appropriate list.
         See README for additional details.
         */

        /*
        (student notes) using a foreach loop, each list is populated with data from the dataArray
        parseInt is used to convert the PUBLISHED_YEAR_FIELD from string to integer
        new BigDecimal used to convert PRICE_FIELD string to BigDecimal
         */

        for (String dataSplit : dataset) {

        String[] dataArray = dataSplit.split(FIELD_DELIMITER);
        titles.add(dataArray[TITLE_FIELD]);
        authors.add(dataArray[AUTHOR_FIELD]);
        int pubYear = Integer.parseInt(dataArray[PUBLISHED_YEAR_FIELD]);
        publishedYears.add(pubYear);
        prices.add(new BigDecimal(dataArray[PRICE_FIELD]));


        }
    }

    private void run() {

        while (true) {
            // Main menu loop
            printMainMenu();
            int mainMenuSelection = promptForMenuSelection("Please choose an option: ");
            if (mainMenuSelection == 1) {
                // Display data and subsets loop
                while (true) {
                    printDataAndSubsetsMenu();
                    int dataAndSubsetsMenuSelection = promptForMenuSelection("Please choose an option: ");
                    if (dataAndSubsetsMenuSelection == 1) {
                        displayDataset(Dataset.load());
                    } else if (dataAndSubsetsMenuSelection == 2) {
                        displayTitlesList(titles);
                    } else if (dataAndSubsetsMenuSelection == 3) {
                        displayAuthorsList(authors);
                    } else if (dataAndSubsetsMenuSelection == 4) {
                        displayPublishedYearsList(publishedYears);
                    } else if (dataAndSubsetsMenuSelection == 5) {
                        displayPricesList(prices);
                    } else if (dataAndSubsetsMenuSelection == 0) {
                        break;
                    }
                }
            }
            else if (mainMenuSelection == 2) {
                while (true) {
                    printSearchBooksMenu();
                    int searchBooksMenuSelection = promptForMenuSelection("Please choose an option: ");
                    if (searchBooksMenuSelection == 1) {
                        // Search by title
                        String filterTitle = promptForString("Enter title: ");
                        /*
                         Requirement: 3b
                         Replace `displayTitlesList(titles)` with calls to the
                         `filterByTitle()` and `displaySearchResults()` methods.
                         */

                        /*

                        (student notes) added method displaySearchResults using
                        results of filterByTitle search method using filterTitle input

                         */

                        displaySearchResults(filterByTitle(filterTitle));

                    } else if (searchBooksMenuSelection == 2) {
                        // Search by author
                        String filterAuthor = promptForString("Enter author: ");
                        /*
                         Requirement: 4b
                         Replace `displayAuthorsList(authors)` with calls to the
                         `filterByAuthor()` and `displaySearchResults()` methods.
                         */

                        /*

                        (student notes) added method displaySearchResults using
                        results of filterByAuthor search method using filterAuthor input

                         */

                        displaySearchResults(filterByAuthor(filterAuthor));

                    } else if (searchBooksMenuSelection == 3) {
                        // Search by published year
                        int filterYear = promptForPublishedYear("Enter date (YYYY): ");
                        /*
                         Requirement: 5b
                         Replace `displayPublishedYearsList(publishedYears)` with calls
                         to the `filterByPublishedYear()` and `displaySearchResults()` methods.
                         */

                        /*

                        (student notes) added method displaySearchResults using
                        results of filterByPublishedYear search method using filterYear input

                         */

                        displaySearchResults(filterByPublishedYear(filterYear));

                    } else if (searchBooksMenuSelection == 4) {
                        // Search by published year range
                        int filterFromYear = promptForPublishedYear("Enter \"from\" date (YYYY): ");
                        int filterToYear = promptForPublishedYear("Enter \"to\" date (YYYY): ");
                        /*
                         Requirement: 6b
                         Replace `displayPublishedYearsList(publishedYears)` with calls
                         to the `filterByPublishedYearRange()` and `displaySearchResults()` methods.
                         */

                        /*

                        (student notes) added method displaySearchResults using
                        results of filterByPublishedYearRange search method using filterFromYear and filterToYear input

                         */

                        displaySearchResults(filterByPublishedYearRange(filterFromYear, filterToYear));

                    } else if (searchBooksMenuSelection == 5) {
                        // Find the most recent books
                        /*
                         Requirement: 7b
                         Replace `displayPublishedYearsList(publishedYears)` with calls
                         to the `findMostRecentBooks()` and `displaySearchResults()` methods.
                         */

                        /*

                        (student notes) added method displaySearchResults using
                        results of findMostRecentBooks search method

                         */

                        displaySearchResults(findMostRecentBooks());

                    } else if (searchBooksMenuSelection == 6) {
                        // Search by price
                        double filterPrice = promptForPrice("Enter price: ");
                        /*
                         Requirement: 8b
                         Replace `displayPricesList(prices)` with calls to the
                         `filterByPrice()` and `displaySearchResults()` methods.
                         */

                        /*

                        (student notes) added method displaySearchResults using
                        results of filterByPrice search method using filterPrice input

                         */

                        displaySearchResults(filterByPrice(filterPrice));

                    } else if (searchBooksMenuSelection == 7) {
                        // Search by price range
                        double filterFromPrice= promptForPrice("Enter \"from\" price: ");
                        double filterToPrice = promptForPrice("Enter \"to\" price: ");
                        /*
                         Requirement: 9b
                         Replace `displayPricesList(prices)` with calls to the
                         `filterByPriceRange()` and `displaySearchResults()` methods.
                         */

                        /*

                        (student notes) added method displaySearchResults using
                        results of filterByPriceRange search method using filterFromPrice and filterToPrice input

                         */

                        displaySearchResults(filterByPriceRange(filterFromPrice, filterToPrice));

                    } else if (searchBooksMenuSelection == 8) {
                        // Find the least expensive books
                        /*
                         Requirement: 10b
                         Replace `displayPricesList(prices)` with calls to the
                         `findLeastExpensiveBooks()` and `displaySearchResults()` methods.
                         */

                        /*

                        (student notes) added method displaySearchResults using
                        results of findLeastExpensiveBooks search method

                         */

                        displaySearchResults(findLeastExpensiveBooks());

                    } else if (searchBooksMenuSelection == 0) {
                        break;
                    }
                }
            } else if (mainMenuSelection == 0) {
                break;
            }
        }

    }

    /*
     Requirement: 2
     Write the displaySearchResults(List<Integer> indexes) method.
     See README for additional details.
     */

    /*
    (student notes) added to body of method to loop through indexes and print corresponding elements from lists
     */

    private void displaySearchResults(List<Integer> indexes) {
        int primaryField = 0;
        for (Integer index : indexes) {
            System.out.println(primaryField + "" + titles.get(index) + ": " + authors.get(index) + ": " + publishedYears.get(index) + ": $" + prices.get(index));
        }
    }

    /* <title>: <author>: <publication year>: $<price>
     Requirement: 3a
     Complete the `filterByTitle()` method.
     See README for additional details.
     */

     /*
    (student notes) Used an incremental for loop to check for any entries in titles list that match filterTitle
    then matching entries are added to resultsTitle list and returned
     */

    private List<Integer> filterByTitle(String filterTitle) {
        List<Integer> resultsTitle = new ArrayList<>();
        for (int i = 0; i < titles.size(); i++) {
            if (titles.get(i).contains(filterTitle)) {
                resultsTitle.add(i);
            }
        } return resultsTitle;
    }

    /*
     Requirement: 4a
     Complete the `filterByAuthor()` method.
     See README for additional details.
     */

     /*
    (student notes) Used an incremental for loop to check for any entries in authors list that match filterAuthor
    then matching entries are added to resultsAuthor list and returned
     */

    private List<Integer> filterByAuthor(String filterAuthor) {
        List<Integer> resultsAuthor = new ArrayList<>();
        for (int i = 0; i < authors.size(); i++) {
            if (authors.get(i).contains(filterAuthor)) {
                resultsAuthor.add(i);
            }
        } return resultsAuthor;
    }

    /*
     Requirement: 5a
     Complete the `filterByPublishedYear()` method.
     See README for additional details.
     */

     /*
    (student notes) Used an incremental for loop to check for any entries in publishedYears list that match filterYear
    then matching entries are added to resultsPubYear list and returned
     */

    private List<Integer> filterByPublishedYear(int filterYear) {
        List<Integer> resultsPubYear = new ArrayList<>();
        for (int i = 0; i < publishedYears.size(); i++) {
            if (publishedYears.get(i) == filterYear) {
                resultsPubYear.add(i);
            }
        } return resultsPubYear;
    }

    /*
     Requirement: 6a
     Complete the `filterByPublishedYearRange()` method.
     See README for additional details.
     */

     /*
    (student notes) Used an incremental for loop to check for any entries in publishedYears list that is more than
    filterFromYear and less than filterToYear and adds matching entries to resultsPubYearRange and returned
     */

    private List<Integer> filterByPublishedYearRange(int filterFromYear, int filterToYear) {
        List<Integer> resultsPubYearRange = new ArrayList<>();
        for (int i = 0; i < publishedYears.size(); i++) {
            if (publishedYears.get(i) >= filterFromYear & publishedYears.get(i) <= filterToYear) {
                resultsPubYearRange.add(i);
            }
        } return resultsPubYearRange;
    }

    /*
     Requirement: 7a
     Add the `private List<Integer> findMostRecentBooks()` method.
     See README for additional details.
     */

    /*
    (student notes) determines most recent published year by using a for loop to check each entry in publishedYears
    if the entry is a higher number than checkMostRecent, the value of checkMostRecent is changed to match the
    publishedYear of the current entry
    another for loop checks publishedYears for any matches to the checkMostCurrent value, adds them to resultsMostRecent
    and then returns it
     */

    private List<Integer> findMostRecentBooks() {
        List<Integer> resultsMostRecent = new ArrayList<>();
        int checkMostRecent = 0;
        for (int i = 0; i < publishedYears.size(); i++) {
            if (publishedYears.get(i) > checkMostRecent) {
                checkMostRecent = publishedYears.get(i);
            }
        }
        for (int i = 0; i < publishedYears.size(); i++) {
            if (publishedYears.get(i) == checkMostRecent) {
                resultsMostRecent.add(i);
            }
        } return resultsMostRecent;
    }

    /*
     Requirement: 8a
     Complete the `filterByPrice()` method.
     See README for additional details.
     */

     /*
    (student notes) converted double filterPrice to BigDecimal filterPriceBigDecimal, used for loop to check each entry
    in prices - for any prices that are less than or equal to filterPricesBigDecimal, returns entry to resultsBelowPrice
    and returns it
     */

    private List<Integer> filterByPrice(double filterPrice) {
        List<Integer> resultsBelowPrice = new ArrayList<>();
        BigDecimal filterPriceBigDecimal = new BigDecimal(filterPrice);
        for (int i = 0; i < prices.size(); i++) {
            if (prices.get(i).compareTo(filterPriceBigDecimal) <= 0) {
                resultsBelowPrice.add(i);
            }
        } return resultsBelowPrice;
    }

    /*
     Requirement: 9a
     Complete the `filterByPriceRange()` method.
     See README for additional details.
     */

     /*
    (student notes) converts filterFromPrice and filterToPrice to corresponding BigDecimals and then using another for
    loop, checks each entry in prices and adds entries between filterFromPrice and filterToPrice to resultsPriceRange
    and returns it
     */

    private List<Integer> filterByPriceRange(double filterFromPrice, double filterToPrice) {
        List<Integer> resultsPriceRange = new ArrayList<>();
        BigDecimal filterFromPriceBigDecimal = new BigDecimal(filterFromPrice);
        BigDecimal filterToPriceBigDecimal = new BigDecimal(filterToPrice);
        for (int i = 0; i < prices.size(); i++) {
           if (prices.get(i).compareTo(filterFromPriceBigDecimal) >= 0
                   & prices.get(i).compareTo(filterToPriceBigDecimal) <= 0) {
               resultsPriceRange.add(i);
           }
        } return resultsPriceRange;
    }

    /*
     Requirement: 10a
     Add the `private List<Integer> findLeastExpensiveBooks()` method.
     See README for additional details.
     */

     /*
    (student notes) converts the value of prices(0) to BigDecimal and declares it as BigDecimal lowestCost, then
    compares each entry in prices list, if the value is below the current value of lowestCost, lowestCost is replaced
    with the current prices(i) value
    using another for loop, checks each entry in prices list for match to lowestCost and adds results to
    resultsLeastExpensive and returns it

     */

    private List<Integer> findLeastExpensiveBooks() {
        List<Integer> resultsLeastExpensive = new ArrayList<>();
        BigDecimal lowestCost = new BigDecimal(String.valueOf(prices.get(0)));
        for (int i = 0; i < prices.size(); i++) {
            if (prices.get(i).compareTo(lowestCost) < 0) {
                lowestCost = prices.get(i);
            }
        }
        for (int i = 0; i < prices.size(); i++) {
            if (prices.get(i).equals(lowestCost)) {
                resultsLeastExpensive.add(i);
            }
        } return resultsLeastExpensive;
    }

    // UI methods

    private void printMainMenu() {
        System.out.println("1: Display data and subsets");
        System.out.println("2: Search books");
        System.out.println("0: Exit");
        System.out.println();
    }

    private void printDataAndSubsetsMenu() {
        System.out.println("1: Display dataset");
        System.out.println("2: Display titles");
        System.out.println("3: Display authors");
        System.out.println("4: Display published years");
        System.out.println("5: Display prices");
        System.out.println("0: Return to main menu");
        System.out.println();
    }

    private void printSearchBooksMenu() {
        System.out.println("1: Search by title");
        System.out.println("2: Search by author");
        System.out.println("3: Search by published year");
        System.out.println("4: Search by published year range");
        System.out.println("5: Find most recent books");
        System.out.println("6: Search by price");
        System.out.println("7: Search by price range");
        System.out.println("8: Find least expensive books");
        System.out.println("0: Return to main menu");
        System.out.println();
    }

    private void displayDataset(String[] dataset) {
        System.out.println("Dataset");
        System.out.println("-------");
        for (String data : dataset) {
            System.out.println(data);
        }
        System.out.println();
        promptForReturn();
    }

    private void displayTitlesList(List<String> titles) {
        System.out.println("Titles");
        System.out.println("-------");
        for (int i = 0; i < titles.size(); i++) {
            System.out.println(i + ": " + titles.get(i));
        }
        System.out.println();
        promptForReturn();
    }

    private void displayAuthorsList(List<String> authors) {
        System.out.println("Authors");
        System.out.println("-------");
        for (int i = 0; i < authors.size(); i++) {
            System.out.println(i + ": " + authors.get(i));
        }
        System.out.println();
        promptForReturn();
    }

    private void displayPublishedYearsList(List<Integer> publishedYears) {
        System.out.println("Published Years");
        System.out.println("---------------");
        for (int i = 0; i < publishedYears.size(); i++) {
            System.out.println(i + ": " + publishedYears.get(i));
        }
        System.out.println();
        promptForReturn();
    }

    private void displayPricesList(List<BigDecimal> prices) {
        System.out.println("Prices");
        System.out.println("------");
        for (int i = 0; i < prices.size(); i++) {
            System.out.println(i + ": " + prices.get(i));
        }
        System.out.println();
        promptForReturn();
    }

    private int promptForMenuSelection(String prompt) {
        System.out.print(prompt);
        int menuSelection;
        try {
            menuSelection = Integer.parseInt(keyboard.nextLine());
        } catch (NumberFormatException e) {
            menuSelection = -1;
        }
        return menuSelection;
    }

    private String promptForString(String prompt) {
        System.out.print(prompt);
        return keyboard.nextLine();
    }

    private int promptForPublishedYear(String prompt) {
        int year;
        while (true) {
            System.out.println(prompt);
            try {
                year = Integer.parseInt(keyboard.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("The year provided is not well-formed. It must be YYYY.");
            }
        }
        return year;
    }

    private double promptForPrice(String prompt) {
        double price;
        while (true) {
            System.out.println(prompt);
            try {
                price = Double.parseDouble(keyboard.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("The price provided is not a valid monetary value.");
            }
        }
        return price;
    }

    private void promptForReturn() {
        System.out.println("Press RETURN to continue.");
        keyboard.nextLine();
    }
}
