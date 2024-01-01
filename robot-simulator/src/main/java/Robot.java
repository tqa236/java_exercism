class Robot {

  private GridPosition position;
  private Orientation orientation;

  Robot(GridPosition position, Orientation orientation) {
    this.position = position;
    this.orientation = orientation;
  }

  public Orientation getOrientation() {
    return orientation;
  }

  public GridPosition getGridPosition() {
    return position;
  }

  public void turnLeft() {
    orientation = switch (orientation) {
      case NORTH -> Orientation.WEST;
      case WEST -> Orientation.SOUTH;
      case SOUTH -> Orientation.EAST;
      case EAST -> Orientation.NORTH;
    };
  }

  public void turnRight() {
    orientation = switch (orientation) {
      case NORTH -> Orientation.EAST;
      case EAST -> Orientation.SOUTH;
      case SOUTH -> Orientation.WEST;
      case WEST -> Orientation.NORTH;
    };
  }

  public void advance() {
    switch (orientation) {
      case NORTH:
        position = new GridPosition(position.x, position.y + 1);
        break;
      case EAST:
        position = new GridPosition(position.x + 1, position.y);
        break;
      case SOUTH:
        position = new GridPosition(position.x, position.y - 1);
        break;
      case WEST:
        position = new GridPosition(position.x - 1, position.y);
    }
  }

  public void simulate(String movements) {
    for (int i = 0; i < movements.length(); i++) {
      char c = movements.charAt(i);
      switch (c) {
        case 'L':
          turnLeft();
          break;
        case 'R':
          turnRight();
          break;
        case 'A':
          advance();
      }
    }
  }
}
