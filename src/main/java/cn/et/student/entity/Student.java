package cn.et.student.entity;

public class Student {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.sid
     *
     * @mbg.generated Sat Dec 09 09:50:19 CST 2017
     */
    private Integer sid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.sname
     *
     * @mbg.generated Sat Dec 09 09:50:19 CST 2017
     */
    private String sname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.gid
     *
     * @mbg.generated Sat Dec 09 09:50:19 CST 2017
     */
    private Integer gid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.ssex
     *
     * @mbg.generated Sat Dec 09 09:50:19 CST 2017
     */
    private Integer ssex;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.saddress
     *
     * @mbg.generated Sat Dec 09 09:50:19 CST 2017
     */
    private String saddress;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.sid
     *
     * @return the value of student.sid
     *
     * @mbg.generated Sat Dec 09 09:50:19 CST 2017
     */
    public Integer getSid() {
        return sid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.sid
     *
     * @param sid the value for student.sid
     *
     * @mbg.generated Sat Dec 09 09:50:19 CST 2017
     */
    public void setSid(Integer sid) {
        this.sid = sid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.sname
     *
     * @return the value of student.sname
     *
     * @mbg.generated Sat Dec 09 09:50:19 CST 2017
     */
    public String getSname() {
        return sname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.sname
     *
     * @param sname the value for student.sname
     *
     * @mbg.generated Sat Dec 09 09:50:19 CST 2017
     */
    public void setSname(String sname) {
        this.sname = sname == null ? null : sname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.gid
     *
     * @return the value of student.gid
     *
     * @mbg.generated Sat Dec 09 09:50:19 CST 2017
     */
    public Integer getGid() {
        return gid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.gid
     *
     * @param gid the value for student.gid
     *
     * @mbg.generated Sat Dec 09 09:50:19 CST 2017
     */
    public void setGid(Integer gid) {
        this.gid = gid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.ssex
     *
     * @return the value of student.ssex
     *
     * @mbg.generated Sat Dec 09 09:50:19 CST 2017
     */
    public Integer getSsex() {
        return ssex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.ssex
     *
     * @param ssex the value for student.ssex
     *
     * @mbg.generated Sat Dec 09 09:50:19 CST 2017
     */
    public void setSsex(Integer ssex) {
        this.ssex = ssex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.saddress
     *
     * @return the value of student.saddress
     *
     * @mbg.generated Sat Dec 09 09:50:19 CST 2017
     */
    public String getSaddress() {
        return saddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.saddress
     *
     * @param saddress the value for student.saddress
     *
     * @mbg.generated Sat Dec 09 09:50:19 CST 2017
     */
    public void setSaddress(String saddress) {
        this.saddress = saddress == null ? null : saddress.trim();
    }
}