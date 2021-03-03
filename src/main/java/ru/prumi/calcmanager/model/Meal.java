package ru.prumi.calcmanager.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "meals", uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "date"},
        name = "meals_unique_user_datetime_idx")})
public class Meal extends AbstractBaseEntity{

    @Id
    private Integer id;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "calories", nullable = false)
    private int calories;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "weight", nullable = false)
    private double weight;

    @Column(name = "fats", nullable = false)
    private double fats;

    @Column(name = "proteins", nullable = false)
    private double proteins;

    @Column(name = "carbohydrates", nullable = false)
    private double carbohydrates;

    private User user;

    public Meal() {
    }

    public Meal(Date date, int calories, String description,
                double weight, double fats, double proteins, double carbohydrates) {
        this(null, date, calories, description, weight, fats, proteins, carbohydrates);
    }

    public Meal(Integer id, Date date, int calories, String description,
                double weight, double fats, double proteins, double carbohydrates) {
        super(id);
        this.date = date;
        this.calories = calories;
        this.description = description;
        this.weight = weight;
        this.fats = fats;
        this.proteins = proteins;
        this.carbohydrates = carbohydrates;
    }

    @Id
    public Integer getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public int getCalories() {
        return calories;
    }

    public String getDescription() {
        return description;
    }

    public double getWeight() {
        return weight;
    }

    public double getFats() {
        return fats;
    }

    public double getProteins() {
        return proteins;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public User getUser(){return user;}

    public void setDate(Date date) {
        this.date = date;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setFats(double fats) {
        this.fats = fats;
    }

    public void setProteins(double proteins) {
        this.proteins = proteins;
    }

    public void setCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUser(User user){
        this.user = user;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "id=" + id +
                ", date=" + date +
                ", calories=" + calories +
                ", description='" + description + '\'' +
                ", weight=" + weight +
                ", fats=" + fats +
                ", proteins=" + proteins +
                ", carbohydrates=" + carbohydrates +
                ", user=" + user +
                '}';
    }
}
