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
    orientation = orientation.previous();
  }

  public void turnRight() {
    orientation = orientation.next();
  }

  public void advance() {
    switch (orientation) {
      case NORTH:
        position = new GridPosition(position.getX(), position.getY() + 1);
        break;
      case EAST:
        position = new GridPosition(position.getX() + 1, position.getY());
        break;
      case SOUTH:
        position = new GridPosition(position.getX(), position.getY() - 1);
        break;
      case WEST:
        position = new GridPosition(position.getX() - 1, position.getY());
        break;
      default:
        throw new IllegalArgumentException("Unknow orientation");
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
          break;
        default:
          throw new IllegalArgumentException("Unknow movement");
      }
    }
  }
}
