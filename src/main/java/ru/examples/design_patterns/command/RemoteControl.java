package ru.examples.design_patterns.command;

public class RemoteControl {
    private Command[] onCommand;
    private Command[] offCommand;

    public RemoteControl() {
        onCommand = new Command[7];
        offCommand = new Command[7];
        Command noCommand = new NoCommand();
        for (int i = 0; i < 7; i++) {
           onCommand[i] = noCommand;
           offCommand[i] = noCommand;
        }
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        this.onCommand[slot] = onCommand;
        this.offCommand[slot] = offCommand;
    }

    public void onButtonWasPushed(int slot) {
        onCommand[slot].execute();
    }

    public void offButtonWasPushed(int slot) {
        offCommand[slot].execute();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n------ Remote Control ------\n");
        for (int i = 0; i < onCommand.length; i++) {
            stringBuilder.append("[slot ")
                    .append(i).append("] ")
                    .append(onCommand[i].getClass().getName())
                    .append("   ")
                    .append(offCommand[i].getClass().getName()).append("\n");
        }
        return stringBuilder.toString();
    }
}
