package com.example.pallavi.reelreview;

/**
 * Created by Pallavi on 08-10-2017.
 */

public class GetMovieDetailsFromDB {
    String mname,myar,mrate,mtime,mgenre,mdescription,mcast;

    public GetMovieDetailsFromDB() {
    }

    public GetMovieDetailsFromDB(String mname, String myar, String mrate, String mtime, String mgenre, String mdescription, String mcast) {
        this.mname = mname;
        this.myar = myar;
        this.mrate = mrate;
        this.mtime = mtime;
        this.mgenre = mgenre;
        this.mdescription = mdescription;
        this.mcast = mcast;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getMyar() {
        return myar;
    }

    public void setMyar(String myar) {
        this.myar = myar;
    }

    public String getMrate() {
        return mrate;
    }

    public void setMrate(String mrate) {
        this.mrate = mrate;
    }

    public String getMtime() {
        return mtime;
    }

    public void setMtime(String mtime) {
        this.mtime = mtime;
    }

    public String getMgenre() {
        return mgenre;
    }

    public void setMgenre(String mgenre) {
        this.mgenre = mgenre;
    }

    public String getMdescription() {
        return mdescription;
    }

    public void setMdescription(String mdescription) {
        this.mdescription = mdescription;
    }

    public String getMcast() {
        return mcast;
    }

    public void setMcast(String mcast) {
        this.mcast = mcast;
    }
}
