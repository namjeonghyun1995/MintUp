package com.badminton.mintup.common;

import com.badminton.mintup.Enum.RegexType;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.regex.Pattern;

@Component
public class RegexUtil {

    private static final Map<RegexType, Pattern> PATTERNS = Map.of(
            RegexType.EMAIL,
            Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")
    );

    public boolean regex(RegexType type, String value) {
        if (type == null || value == null || value.isBlank()) {
            return false;
        }

        Pattern pattern = PATTERNS.get(type);

        if (pattern == null) {
            return false;
        }

        return pattern.matcher(value).matches();
    }
}
