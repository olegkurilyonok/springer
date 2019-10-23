package regexp;

import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionExample {
    public static final String request = "{\"komplatRequests\":[{\"request\":\"<?xml version=\\\"1.0\\\" encoding=\\\"Windows-1251\\\" standalone=\\\"yes\\\"?><PS_ERIP><GetPayListRequest> <Key><\\/Key><TerminalID>@{terminal_id_mb}<\\/TerminalID><DIType>9120<\\/DIType><Version>3<\\/Version><PayCode>110561<\\/PayCode><PAN Expiry= \\\"#{6YA-AT87aMC35FvTsIOq7Ywfy9h8MDvAxbvcVkye_iP6dJpiYI-J3PgzvFZ0KdKRvoxK1CsdNtkLrhdP1pKiRQ@[card_expire]}\\\" ExtraRs= \\\"#{6YA-AT87aMC35FvTsIOq7Ywfy9h8MDvAxbvcVkye_iP6dJpiYI-J3PgzvFZ0KdKRvoxK1CsdNtkLrhdP1pKiRQ@[card_extrars]}\\\">#{6YA-AT87aMC35FvTsIOq7Ywfy9h8MDvAxbvcVkye_iP6dJpiYI-J3PgzvFZ0KdKRvoxK1CsdNtkLrhdP1pKiRQ@[card_mask_number]}<\\/PAN><TypePAN>MS<\\/TypePAN><AttrRecord Code=\\\"746\\\" Value=\\\"344576210\\\"/><\\/GetPayListRequest><\\/PS_ERIP>\"}]}";
    public static final Pattern pairPattern = Pattern.compile("#\\{(.*?)\\}");
    public static final Pattern keyPattern = Pattern.compile("(.*?)@(.*?\\[|\\{)(.*?)(?:\\]|\\})");

    @Test
    public void regularExpressionExampleMain() {
        System.out.println(getValueFromRequest(request, Keys4ReplaceValueByKey.CARD_MASK_NUMBER));
    }

    public static String getValueFromRequest(String request, Keys4ReplaceValueByKey searchKey) {
        Matcher matcher = pairPattern.matcher(request);
        while (matcher.find()) {
            Matcher keyMatcher = keyPattern.matcher(matcher.group(1));
            if(keyMatcher.find()) {
                if (searchKey.keyName.equalsIgnoreCase(keyMatcher.group(3))) {
                    return keyMatcher.group(1);
                }
            }
        }
        return null;
    }
}
