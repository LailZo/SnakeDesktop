/*
 * This file is part of Snake, licensed under the MIT License (MIT).
 *
 * Copyright (c) 2018 Neolumia
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.neolumia.snake.view;

import com.neolumia.snake.GameApp;
import com.neolumia.snake.Stats;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;

import static com.neolumia.snake.GameApp.t;

public final class StatisticsWindow extends Window {

  private final GameApp app;
  private final ToggleGroup menu = new ToggleGroup();

  @FXML private GridPane grid;
  @FXML private ToggleButton stats;
  @FXML private ToggleButton history;
  @FXML private ToggleButton leaderboard;

  @FXML private Label statsGames;
  @FXML private Label statsItems;
  @FXML private Label statsPlaytime;
  @FXML private Label statsWall;

  StatisticsWindow(GameApp app) {
    this.app = app;

    stats.setToggleGroup(menu);
    history.setToggleGroup(menu);
    leaderboard.setToggleGroup(menu);

    menu.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
      if (newValue.equals(stats)) {
        grid.add(render("stats"), 0, 0);
      }
    });

    menu.selectToggle(stats);

    update(app.getStats());
  }

  @FXML
  public void cancel() {
    app.getWindowManager().request(new MenuWindow(app));
  }

  private void update(Stats stats) {
    statsGames.setText(t("stats.games", stats.games));
    statsItems.setText(t("stats.items", stats.items));
    statsPlaytime.setText(t("stats.playtime", stats.playtime));
    statsWall.setText(t("stats.walls", stats.walls));
    statsGames.setVisible(true);
    statsItems.setVisible(true);
    statsPlaytime.setVisible(true);
    statsWall.setVisible(true);
  }
}