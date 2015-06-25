package com.music.controller;

import java.io.File;

import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.AudioHeader;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TagController {
	
	@ResponseBody
	@RequestMapping(value = "/tag")
   public void compare() throws Exception {
	   File file = new File("C:\\Music.mp3");
	   
	   AudioFile audio = AudioFileIO.read(file);
	   Tag tag = audio.getTag();
	   AudioHeader header = audio.getAudioHeader();	   
	   System.out.println("Bitrate: "+header.getBitRateAsNumber()+"kbps");
	   System.out.println("Track Length: "+header.getTrackLength()+" Second");
	   
	   tag.setField(FieldKey.ARTIST,"Moein");
	   tag.setField(FieldKey.TITLE,"Shomal");
	   audio.commit();
	   
	   System.out.println(tag.getFirst(FieldKey.ARTIST));
	   System.out.println(tag.getFirst(FieldKey.TITLE));	   
	   
   }

}