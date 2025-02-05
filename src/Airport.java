import java.util.ArrayList;

public class Airport
{
    /** A list of the flights into and out of this airport
     *  Guaranteed not to be null and to contain only non-null entries
     */
    private ArrayList<Flight> allFlights;

    public Airport(ArrayList<Flight> flights)
    {
        allFlights = flights;
    }

    public ArrayList<Flight> getAllFlights()
    {
        return allFlights;
    }

    /** Returns the revenue generated by all flights at the airport,
     *  as described in part (a)
     */
    public double getTotalRevenue()
    {
        double money = 0;
        int passengers = 0;
        for (Flight flights : allFlights)
        {
            if (flights.getCapacity() < flights.getNumPassengers())
            {
                passengers = flights.getCapacity();
            }
            else
            {
                passengers = flights.getNumPassengers();
            }
            money += passengers * flights.getPrice();
        }
        return money;
    }

    /** Updates the list of flights by removing certain flights and
     *  returns the total number of passengers whose flights were removed,
     *  as described in part (b)
     */
    public int updateFlights()
    {
        int removedPassengers = 0;
        for (int i = 0; i < allFlights.size(); i++)
        {
            if (allFlights.get(i).getNumPassengers() < allFlights.get(i).getCapacity() * .2)
            {
                removedPassengers += allFlights.get(i).getNumPassengers();
                allFlights.remove(i);
            }
        }
        return removedPassengers;
    }
}