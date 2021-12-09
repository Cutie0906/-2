public class Point3d {
    private double xCoord;
    private double yCoord;
    private double zCoord;

    public  Point3d(double xCoord, double yCoord,double zCoord){
        this.xCoord=xCoord;
        this.yCoord=yCoord;
        this.zCoord=zCoord;
    }

    public  Point3d(){
        this(0,0,0);
    }

    public double getX(){
        return xCoord;
    }

    public double getY(){
        return yCoord;
    }

    public double getZ(){
        return zCoord;
    }

    public void setX(double xCoord){
        this.xCoord=xCoord;
    }
    public void setY(double yCoord){
        this.yCoord=yCoord;
    }

    public void setZ(double zCoord){
        this.zCoord=zCoord;
    }

    public boolean equals(Point3d anotherPoint) {
        return xCoord == anotherPoint.getX() &&
                yCoord == anotherPoint.getY() &&
                zCoord == anotherPoint.getZ();
    }
    public double distanceTo(Point3d anotherPoint) {
        return  Math.sqrt(Math.pow(xCoord - anotherPoint.getX(), 2) +
                          Math.pow(yCoord - anotherPoint.getY(), 2) +
                          Math.pow(zCoord - anotherPoint.getZ(), 2));
    }
}

