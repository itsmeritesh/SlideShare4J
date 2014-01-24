package com.taroid.slideshare4j;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*package*/ final class SlideshowConverterImpl implements SlideshowConverter {

    @Override
    public List<Slideshow> convert(InputStream inputStream) {
        if(inputStream == null) {
            throw new NullPointerException("inputStream must not be null.");
        }

        final List<Slideshow> slideshows = new ArrayList<Slideshow>();

        final SAXParser parser;
        try {
            parser = SAXParserFactory.newInstance().newSAXParser();
            parser.parse(inputStream, new SlideShareHandler(slideshows));
        } catch (ParserConfigurationException e) {
            throw new SlideShareException(e);
        } catch (SAXException e) {
            throw new SlideShareException(e);
        } catch (IOException e) {
            throw new SlideShareException(e);
        }

        return slideshows;
    }

    private static class SlideShareHandler extends DefaultHandler {
        private static final String TAG_SLIDESHOW = "Slideshow";
        private static final String TAG_ID = "ID";
        private static final String TAG_TITLE = "Title";
        private static final String TAG_USERNAME = "Username";
        private static final String TAG_DESC = "Description";
        private static final String TAG_URL = "URL";
        private static final String TAG_THUMB_URL = "ThumbnailURL";
        private static final String TAG_CREATED = "Created";
        private static final String TAG_UPDATED = "Updated";
        private static final String TAG_LANG = "Language";
        private static final String TAG_EMBED = "Embed";
        private static final String TAG_TAGS = "Tags";
        private static final String TAG_TAG = "Tag";
        private static final String TAG_FORMAT = "Format";


        private final List<Slideshow> slideshows;

        private final SlideshowBuilder builder = new SlideshowBuilder();

        //Slideshare has changed their date format to something else now
        //2010-07-09 09:55:00 UTC
        private final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");

        private final StringBuilder textBuilder = new StringBuilder();

        public SlideShareHandler(List<Slideshow> result) {
            slideshows = result;
        }

        private Date toDate(String text) {
            try {
                return dateFormat.parse(text);
            } catch (ParseException e) {
                throw new SlideShareException(e);
            }
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            textBuilder.setLength(0);
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            textBuilder.append(String.valueOf(ch, start, length));
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals(TAG_ID)) builder.setID(Integer.parseInt(textBuilder.toString()));
            else if (qName.equals(TAG_TITLE)) builder.setTitle(textBuilder.toString());
            else if (qName.equals(TAG_USERNAME)) builder.setUsername(textBuilder.toString());
            else if (qName.equals(TAG_DESC)) builder.setDescription(textBuilder.toString());
            else if (qName.equals(TAG_URL)) builder.setURL(textBuilder.toString());
            else if (qName.equals(TAG_THUMB_URL)) builder.setThumbnailURL(textBuilder.toString());
            else if (qName.equals(TAG_CREATED)) builder.setCreated(toDate(textBuilder.toString()));
            else if (qName.equals(TAG_UPDATED)) builder.setUpdated(toDate(textBuilder.toString()));
            else if (qName.equals(TAG_LANG)) builder.setLanguage(textBuilder.toString());
            else if (qName.equals(TAG_EMBED)) builder.setEmbed(textBuilder.toString());
            else if (qName.equals(TAG_FORMAT)) builder.setFormat(textBuilder.toString());
            else if (qName.equals(TAG_SLIDESHOW)) {
                slideshows.add(builder.create());
                builder.clear();
            }
        }
    }
}
