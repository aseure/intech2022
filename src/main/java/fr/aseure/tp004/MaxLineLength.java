package fr.aseure.tp004;

class MaxLineLength implements Processor {
    private int max;

    public MaxLineLength() {
        this.max = -1;
    }

    @Override
    public void processLine(String line) {
        if (max < line.length()) {
            max = line.length();
        }
    }

    @Override
    public void report() {
        System.out.println(max);
    }
}