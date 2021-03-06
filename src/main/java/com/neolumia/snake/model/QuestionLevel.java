package com.neolumia.snake.model;

/**
 * This ENUM class represents the level of the game
 */
public enum QuestionLevel {

  ONE("1"), TWO("2"), THREE("3");

  private String level;

  public String getLevel() {
    return this.level;
  }

  QuestionLevel(String level) {
    this.level = level;
  }

}
