package work.TwelveWeek.Two;

public class Student {
    private int xh;                 //学号
    private String xm;              //姓名
    private String xb;              //性别
    private int bj;                 //班级
    private String zym;             //专业名
    private int csrq;               //出生日期
    private String sjzt;            //鬼知道
    private String mz;              //民族

    public Student() {
    }

    public Student(int xh, String xm, String xb, int bj, String zym, int csrq, String sjzt, String mz) {
        this.xh = xh;
        this.xm = xm;
        this.xb = xb;
        this.bj = bj;
        this.zym = zym;
        this.csrq = csrq;
        this.sjzt = sjzt;
        this.mz = mz;

    }

    public int getXh() {
        return xh;
    }

    public void setXh(int xh) {
        this.xh = xh;
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
    }

    public String getXb() {
        return xb;
    }

    public void setXb(String xb) {
        this.xb = xb;
    }

    public int getBj() {
        return bj;
    }

    public void setBj(int bj) {
        this.bj = bj;
    }

    public String getZym() {
        return zym;
    }

    public void setZym(String zym) {
        this.zym = zym;
    }

    public int getCsrq() {
        return csrq;
    }

    public void setCsrq(int csrq) {
        this.csrq = csrq;
    }

    public String getSjzt() {
        return sjzt;
    }

    public void setSjzt(String sjzt) {
        this.sjzt = sjzt;
    }

    public String getMz() {
        return mz;
    }

    public void setMz(String mz) {
        this.mz = mz;
    }
    @Override
    public String toString() {
        return "student{" +
                "xh=" + xh +
                ", xm='" + xm + '\'' +
                ", xb='" + xb + '\'' +
                ", bj=" + bj +
                ", zym='" + zym + '\'' +
                ", csrq=" + csrq +
                ", sjzt='" + sjzt + '\'' +
                ", mz='" + mz + '\'' +
                '}';
    }
}
