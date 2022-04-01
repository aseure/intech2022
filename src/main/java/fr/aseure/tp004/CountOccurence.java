package fr.aseure.tp004;

class CountOccurence implements Processor {
    private final String word;
    private int count;

    public CountOccurence(String word) {
        this.word = word;
        this.count = 0;
    }

    @Override
    public void processLine(String line) {
        int index = 0;
        line = line.toLowerCase();
        while (index != -1) {
            index = line.indexOf(word, index);
            if (index != -1) {
                count++;
                index += word.length();
            }
        }
    }

    @Override
    public void report() {
        System.out.println(count);
    }
}