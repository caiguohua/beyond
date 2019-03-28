package designpattern;
/**
 * µü´úÆ÷Ä£Ê½
 */

import java.util.ArrayList;
import java.util.List;

enum ChannelTypeEnum{
    ENGLISH,FRENCE,CHINESE,HINDI,ALL
}

class Channel{
    private double frequency;
    private ChannelTypeEnum type;

    public Channel(double frequency, ChannelTypeEnum type) {
        this.frequency = frequency;
        this.type = type;
    }

    public double getFrequency() {
        return frequency;
    }

    public ChannelTypeEnum getType() {
        return type;
    }

    @Override
    public String toString() {
        return "frequency = " + this.frequency + " channel = " + this.type;
    }
}

interface ChannelCollection{
    void addChannel(Channel c);
    void removeChannel(Channel c);

    ChannelIterator iterator(ChannelTypeEnum type);
}

interface ChannelIterator{
    boolean hasNext();
    Channel next();
}

class ChannelCollectionImpl implements ChannelCollection{

    private List<Channel> channelList;

    public ChannelCollectionImpl() {
        this.channelList = new ArrayList<>();
    }


    @Override
    public void addChannel(Channel c) {
       this.channelList.add(c);
    }

    @Override
    public void removeChannel(Channel c) {
        this.channelList.remove(c);
    }

    @Override
    public ChannelIterator iterator(ChannelTypeEnum type) {
        return new ChannelIteratorImpl(type,this.channelList);
    }

    private class ChannelIteratorImpl implements ChannelIterator{

        private ChannelTypeEnum type;
        private List<Channel> channels;
        private int position;

        public ChannelIteratorImpl(ChannelTypeEnum type, List<Channel> channels) {
            this.type = type;
            this.channels = channels;
        }

        @Override
        public boolean hasNext() {
            while(position < channelList.size()){
                Channel c = channels.get(position);
                if(c.getType().equals(type) || type.equals(ChannelTypeEnum.ALL)){
                    return true;
                }else{
                    position ++;
                }
            }
            return false;
        }

        @Override
        public Channel next() {
            Channel c = channels.get(position);
            position ++;
            return c;
        }
    }
}

public class RadioChannel {
    public static void main(String[] args) {
        ChannelCollection channels = populationChannels();

        System.out.println("************************************");
        ChannelIterator channelIterator = channels.iterator(ChannelTypeEnum.CHINESE);
        while (channelIterator.hasNext()){
            System.out.println(channelIterator.next().toString());
        }

        System.out.println("************************************");
        ChannelIterator allIterator = channels.iterator(ChannelTypeEnum.ALL);
            while(allIterator.hasNext()){
                System.out.println(allIterator.next().toString());
            }

    }

    private static ChannelCollection populationChannels(){
        ChannelCollection channels = new ChannelCollectionImpl();
        channels.addChannel(new Channel(98.5,ChannelTypeEnum.ENGLISH));
        channels.addChannel(new Channel(99.5,ChannelTypeEnum.FRENCE));
        channels.addChannel(new Channel(100.5,ChannelTypeEnum.ENGLISH));
        channels.addChannel(new Channel(101.5,ChannelTypeEnum.CHINESE));
        channels.addChannel(new Channel(102.5,ChannelTypeEnum.HINDI));
        channels.addChannel(new Channel(103.5,ChannelTypeEnum.ENGLISH));
        channels.addChannel(new Channel(104.5,ChannelTypeEnum.FRENCE));
        channels.addChannel(new Channel(105,ChannelTypeEnum.CHINESE));
        channels.addChannel(new Channel(106,ChannelTypeEnum.ENGLISH));
        channels.addChannel(new Channel(107,ChannelTypeEnum.HINDI));
        return channels;
    }
}
