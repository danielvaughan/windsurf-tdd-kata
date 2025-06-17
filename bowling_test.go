package bowling

import "testing"

func TestGutterGame(t *testing.T) {
	game := "--------------------"
	expected := 0
	actual := Score(game)
	if actual != expected {
		t.Errorf("Score(%s) = %d; want %d", game, actual, expected)
	}
}
