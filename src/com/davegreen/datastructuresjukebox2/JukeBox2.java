/*
 * There is a problem with this in that the code prints out all the duplicates
 * See DataStructutreJukeBox2 for using Sets(type of collection that does not allow duplicates) instead of ArrayLists
 */
package com.davegreen.datastructuresjukebox2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeSet;

/**
 *
 * @author Dave
 */
public class JukeBox2
{
    private ArrayList<JukeBox2Songs> songList;
    
    public JukeBox2()
    {
        songList = new ArrayList<JukeBox2Songs>();
    }
    
    public void go()
    {
        getSongs();
        
        System.out.println("THIS IS THE UNSORTED LIST");
        System.out.println("##########################");
        System.out.println(songList);
        System.out.println("##########################");
        System.out.println("THIS IS THE SORTED LIST BY TITLE WITH DUPLICATES");
        
        Collections.sort(songList);
        System.out.println("##########################");
        System.out.println(songList);
        System.out.println("##########################");
        
        System.out.println("THIS IS THE HASH SET NOT SORTED AND WITH NO DUPLICATES");
        HashSet<JukeBox2Songs> songSet = new HashSet<JukeBox2Songs>();
        songSet.addAll(songList);
        System.out.println(songSet);
        System.out.println("###########################");
        
        System.out.println("THIS IS A TREE SET WHICH TAKES CARE OF DUPLICATEs AND SORTS THEM BACK INTO ORDER");
        TreeSet<JukeBox2Songs> songSet2 = new TreeSet<JukeBox2Songs>();
        songSet2.addAll(songList);
        System.out.println(songSet2);
        System.out.println("#############################");
//        ArtistCompare artistCompare = new ArtistCompare();
//        System.out.println("THIS IS THE SORTED LIST BY ARTIST");
//        
//        Collections.sort(songList, artistCompare);
//        System.out.println("##################################");
//        System.out.println(songList);
    }
    
    public void getSongs()
    {
        try
        {
            File file = new File("SongList.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while((line = reader.readLine()) != null)
            {
                addSong(line);
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    public void addSong(String lineToParse)
    {
        String[] tokens = lineToParse.split("/");
        
        JukeBox2Songs nextSong = new JukeBox2Songs(tokens[0], tokens[1], tokens[2], tokens[3]);
        songList.add(nextSong);
    }
    
    public class ArtistCompare implements Comparator<JukeBox2Songs>
    {

        @Override
        public int compare(JukeBox2Songs one, JukeBox2Songs two)
        {
            return one.getArtist().compareTo(two.getArtist());
        } 
    }
}