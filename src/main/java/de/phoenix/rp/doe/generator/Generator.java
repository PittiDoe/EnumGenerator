package de.phoenix.rp.doe.generator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;

public class Generator {

	public static void main(String[] args) {

		try {
			
			@SuppressWarnings("resource")
			Stream<String> lineStream = Files.lines(Paths.get("C:\\IDE\\test.txt"));
			List<String> lines = lineStream.collect(Collectors.toList());
			
			StringBuilder stringBuilder = new StringBuilder();
			String enumName = "";
			String enumValue1 = "";
			String enumValue2 = "";
			
            for(String currentString : lines) {
            	enumName = StringUtils.deleteWhitespace(StringUtils.substringBefore(currentString, ":"));
            	enumValue1 = StringUtils.deleteWhitespace(StringUtils.substringBefore(currentString, ":"));
            	enumValue2 = StringUtils.deleteWhitespace(StringUtils.substringAfter(currentString, ":"));
            	
            	if(StringUtils.contains(enumName, "\"")) {
            		enumName = StringUtils.remove(enumName, "\"");
            	}
            	
            	if(StringUtils.contains(enumValue1, "\"")) {
            		enumValue1 = StringUtils.remove(enumValue1, "\"");
            	}
            	
            	if(StringUtils.contains(enumValue2, "\"")) {
            		enumValue2 = enumValue2.replace("\"", "");
            	}
            	
            	stringBuilder.append(StringUtils.upperCase(enumName))
            				 .append("(\"")
            				 .append(enumValue1)
            				 .append("\"")
            				 .append("; ")
            				 .append("\"")
            				 .append(enumValue2)
            				 .append("\"")
            				 .append("),\n");
            	
            	System.out.println(stringBuilder.toString());
            }

        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
	}

}
