class Markdown {

    String parse(String markdown) {
        String[] lines = markdown.split("\n");
        String result = "";
        boolean activeList = false;

        for (int i = 0; i < lines.length; i++) {

            String theLine = parseHeader(lines[i]);

            if (theLine == null) {
                theLine = parseListItem(lines[i]);
            }

            if (theLine == null) {
                theLine = parseParagraph(lines[i]);
            }

            if (theLine.matches("(<li>).*") && !theLine.matches("(<h).*") && !theLine.matches("(<p>).*") && !activeList) {
                activeList = true;
                result += "<ul>";
                result += theLine;
            } 
            else if (!theLine.matches("(<li>).*") && activeList) {
                activeList = false;
                result += "</ul>";
                result += theLine;
            } else {
                result += theLine;
            }
        }

        if (activeList) {
            result += "</ul>";
        }

        return result;
    }

    private String parseHeader(String markdown) {
        int count = 0;

        for (int i = 0; i < markdown.length() && markdown.charAt(i) == '#'; i++) {
            count++;
        }
        if (count > 6) { 
            return "<p>" + markdown + "</p>"; 
        }
        if (count == 0) { 
            return null; 
        }

        return "<h" + Integer.toString(count) + ">" + markdown.substring(count + 1).trim() + "</h" + Integer.toString(count) + ">";
    }

    private String parseListItem(String markdown) {
        if (markdown.startsWith("*")) {
            String skipAsterisk = markdown.substring(2);
            String listItemString = parseSomeSymbols(skipAsterisk);
            return "<li>" + listItemString + "</li>";
        }
        return null;
    }

    private String parseParagraph(String markdown) {
        return "<p>" + parseSomeSymbols(markdown) + "</p>";
    }

    private String parseSomeSymbols(String markdown) {
        String lookingFor = "__(.+)__";
        String update = "<strong>$1</strong>";
        String workingOn = markdown.replaceAll(lookingFor, update);

        lookingFor = "_(.+)_";
        update = "<em>$1</em>";
        return workingOn.replaceAll(lookingFor, update);
    }
}
