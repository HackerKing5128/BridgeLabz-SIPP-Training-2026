// MealPlan interface
interface MealPlan {
    String getMealName();
}

// classes implementing the MealPlan interface
class VegetarianMeal implements MealPlan {
    private String mealName;

    public VegetarianMeal(String mealName) {
        this.mealName = mealName;
    }

    public String getMealName() {
        return mealName;
    }
}

class VeganMeal implements MealPlan {
    private String mealName;

    public VeganMeal(String mealName) {
        this.mealName = mealName;
    }

    public String getMealName() {
        return mealName;
    }
}

class KetoMeal implements MealPlan {
    private String mealName;

    public KetoMeal(String mealName) {
        this.mealName = mealName;
    }

    public String getMealName() {
        return mealName;
    }
}

class HighProteinMeal implements MealPlan {
    private String mealName;

    public HighProteinMeal(String mealName) {
        this.mealName = mealName;
    }

    public String getMealName() {
        return mealName;
    }
}

// generic Meal class that can hold any type of MealPlan
class Meal<T extends MealPlan> {
    T mealPlan;

    public Meal(T mealPlan) {
        this.mealPlan = mealPlan;
    }
}

// main class
public class PersonalizedMealPlanGenerator {
    public static void main(String[] args) {
        Meal<VegetarianMeal> meal1 = new Meal<VegetarianMeal>(new VegetarianMeal("Vegetarian Lunch"));
        Meal<VeganMeal> meal2 = new Meal<VeganMeal>(new VeganMeal("Vegan Dinner"));
        Meal<KetoMeal> meal3 = new Meal<KetoMeal>(new KetoMeal("Keto Breakfast"));

        generateMealPlan(meal1);
        generateMealPlan(meal2);
        generateMealPlan(meal3);
    }

    public static <T extends MealPlan> void generateMealPlan(Meal<T> meal) {
        if (meal != null && meal.mealPlan != null) {
            System.out.println("Meal plan generated: " + meal.mealPlan.getMealName());
        } else {
            System.out.println("Invalid meal plan");
        }
    }
}

