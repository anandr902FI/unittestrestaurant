import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class RestaurantService {
	private static List<Restaurant> restaurants = new ArrayList<>();

	public RestaurantService() {
		Restaurant r = new Restaurant("Name of the restaurant", "Location", LocalTime.NOON, LocalTime.MIDNIGHT);
		restaurants.add(r);
	}

	public Restaurant findRestaurantByName(String restaurantName) throws restaurantNotFoundException {
		for (Restaurant r : restaurants) {
			if (r.getName().equals(restaurantName)) {
				return r;
			} else {
				continue;
			}
		}
		throw new restaurantNotFoundException("Restaurant was not found");
	}

	public Restaurant addRestaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
		Restaurant newRestaurant = new Restaurant(name, location, openingTime, closingTime);
		restaurants.add(newRestaurant);
		return newRestaurant;
	}

	public Restaurant removeRestaurant(String restaurantName) throws restaurantNotFoundException {
		Restaurant restaurantToBeRemoved = findRestaurantByName(restaurantName);
		restaurants.remove(restaurantToBeRemoved);
		return restaurantToBeRemoved;
	}

	public List<Restaurant> getRestaurants() {
		return restaurants;
	}
}
