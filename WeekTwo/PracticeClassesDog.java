package WeekTwo;

public class PracticeClassesDog {

    // Always private and always use the class version
    private String breed;
    private String size;
    private Double weight;
    private String color;
    private String behavior;

    
    // right click, source action click constructors. first time select none and second time select all
    
    public PracticeClassesDog() {
    }

    

    public PracticeClassesDog(String breed, String size, Double weight, String color, String behavior) {
        this.breed = breed;
        this.size = size;
        this.weight = weight;
        this.color = color;
        this.behavior = behavior;
    }



    public void bark() {
        System.out.println("woof woof");
    }

    public void sleep() {
        System.out.println("snore snore");
    }

    public void eat() {
        System.out.println("chomp chomp");
    }

    // right click, source action, click getters and setters
    public String getBreed() {
        return breed;
    }
    public void setBreed(String breed) {
        this.breed = breed;
    }
    public String getSize() {
        return size;
    }
    public void setSize(String size) {
        this.size = size;
    }
    public Double getWeight() {
        return weight;
    }
    public void setWeight(Double weight) {
        this.weight = weight;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getBehavior() {
        return behavior;
    }
    public void setBehavior(String behavior) {
        this.behavior = behavior;
    }


    // generate toString to see all the variables 
    @Override
    public String toString() {
        return "PracticeClassesDog [breed=" + breed + ", size=" + size + ", weight=" + weight + ", color=" + color
                + ", behavior=" + behavior + "]";
    }

    
    

}