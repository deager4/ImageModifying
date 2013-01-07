package me.deager4.imagemodifying;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class IMCommandHandler
{
	private HashMap<Integer, String> commandMap = new HashMap<Integer, String>();
	private ArrayList<String> commandList = new ArrayList<String>();
	private int numOfCommands = 0;
	public IMCommandHandler(String input, ArrayList<String> commands)
	{
		StringTokenizer a = new StringTokenizer(input, " ");
		commandList = commands;
		numOfCommands = a.countTokens();
		for(int count = 0; count < numOfCommands; count ++)
		{
			String formattedInput =  a.nextToken().toLowerCase();
			commandMap.put(count, formattedInput);
		}
	}
	
	public String[] handle()
	{
		ArrayList <String> list = new ArrayList<String>();
		for(int count = 0; count < numOfCommands; count ++)
		{
			if(!commandList.contains(commandMap.get(count)))
			{
				list.add("##error##");
			}
			else
			{
				list.add(commandMap.get(commandMap.get(count)));
			}
			
		}
		String[] commands = (String[]) list.toArray();
		
		return commands;
	}
}
