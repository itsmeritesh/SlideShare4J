package com.taroid.slideshare4j;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * {@link SlideShare}の骨格実装
 */
public abstract class AbstractSlideShare implements SlideShare {

    private final String apiKey;

    private final String sharedSecret;

    /**
     * @param apiKey
     * @param sharedSecret
     * @throws java.lang.NullPointerException 引数が{@code null}の場合
     */
    public AbstractSlideShare(final String apiKey, final String sharedSecret) {
        if(apiKey == null) {
            throw new NullPointerException("apiKey must not be null.");
        }
        if(sharedSecret == null) {
            throw new NullPointerException("sharedSecret must not be null.");
        }

        this.apiKey = apiKey;
        this.sharedSecret = sharedSecret;
    }

    /**
     * API KEYを返します。
     * @return API KEY
     */
    protected final String getAPIKey() {
        return apiKey;
    }

    /**
     * Shared Secretを返します。
     * @return Shared Secret
     */
    protected final String getSharedSecret() {
        return sharedSecret;
    }

    /**
     * 現在の時刻を秒単位で返します。
     * @return 現在の時刻(秒単位)
     */
    protected final long getCurrentTimeSeconds() {
        return System.currentTimeMillis() / 1000;
    }

    /**
     * SlideShare APIに必要なハッシュ値を求めて返します。
     * @return SlideShare APIに必要なハッシュ値
     */
    protected final String getHash() {
        return toSha1Hex(getSharedSecret() + getCurrentTimeSeconds());
    }

    private static String toSha1Hex(final String text) {
        final MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-1");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        md.update(text.getBytes());

        final StringBuilder builder = new StringBuilder();
        for(byte b: md.digest()) {
            builder.append(String.format("%02x", b));
        }

        return builder.toString();
    }
}
