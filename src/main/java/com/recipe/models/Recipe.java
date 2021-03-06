package com.recipe.models;

import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="recipes")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String imageUrl;

    @OneToMany(mappedBy = "recipe",fetch = FetchType.LAZY)
    private List<Ingredient> ingredients;

    private String directions;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "categories_recipes", 
        joinColumns = @JoinColumn(name = "recipe_id"), 
        inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categories;
    
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "creator_id")
	private User creator;
    
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "favrecipes_favusers", joinColumns = @JoinColumn(name = "favrecipe_id"), inverseJoinColumns = @JoinColumn(name = "favuser_id"))
	private List<User> favusers;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "reviews", joinColumns = @JoinColumn(name = "reviewrecipe_id"), inverseJoinColumns = @JoinColumn(name = "reviewer_id"))
    private List<User> reviewers;
    	
	public Recipe() {
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDirections() {
		return directions;
	}

	public void setDirections(String directions) {
		this.directions = directions;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public List<User> getFavusers() {
		return favusers;
	}

	public void setFavusers(List<User> favusers) {
		this.favusers = favusers;
	}

	public List<User> getReviewers() {
		return reviewers;
	}

	public void setReviewers(List<User> reviewers) {
		this.reviewers = reviewers;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

}
