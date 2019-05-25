/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davegreen.datastructuresjukebox2;

/**
 *
 * @author Dave
 */
public class JukeBox2Songs implements Comparable<JukeBox2Songs>
{
    private String title;
    private String artist;
    private String rating;
    private String bpm;
    
    public JukeBox2Songs(String t, String a, String r, String b)
    {
        title = t;
        artist = a;
        rating = r;
        bpm = b;
    }

    @Override
    public boolean equals(Object aSong)
    {
        JukeBox2Songs s = (JukeBox2Songs) aSong;
        return getTitle().equals(s.getTitle());
    }

    @Override
    public int hashCode()
    {
        return title.hashCode();
    }
    
    @Override
    public int compareTo(JukeBox2Songs o)
    {
        return title.compareTo(o.getTitle());
    }
    
    public String getTitle()
    {
        return title;
    }

    public String getArtist()
    {
        return artist;
    }

    public String getRating()
    {
        return rating;
    }

    public String getBpm()
    {
        return bpm;
    }
    
//    // toString method as per the book
//    public String toString()
//    {
//        return title;
//    }
 
    // toString method as per the auto generation menu
    @Override
    public String toString()
    {
        return "SONG{" + "title = " + title + ", artist = " + artist +'}';
    }
}