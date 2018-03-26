package com.command;

import java.util.*;
import static java.awt.event.KeyEvent.*;

class CharacterCommands
{
    private static final Map<Character, List<Integer>> CHARACTER_COMMANDS = new HashMap<>();

    static
    {
        CHARACTER_COMMANDS.put(' ', Collections.unmodifiableList(Arrays.asList(VK_SPACE)));
        CHARACTER_COMMANDS.put('!', Collections.unmodifiableList(Arrays.asList(VK_SHIFT, VK_EXCLAMATION_MARK)));
        CHARACTER_COMMANDS.put('"', Collections.unmodifiableList(Arrays.asList(VK_SHIFT, VK_QUOTEDBL)));
        CHARACTER_COMMANDS.put('#', Collections.unmodifiableList(Arrays.asList(VK_SHIFT, VK_NUMBER_SIGN)));
        CHARACTER_COMMANDS.put('$', Collections.unmodifiableList(Arrays.asList(VK_SHIFT, VK_DOLLAR)));
        CHARACTER_COMMANDS.put('%', Collections.unmodifiableList(Arrays.asList(VK_SHIFT, VK_5)));
        CHARACTER_COMMANDS.put('&', Collections.unmodifiableList(Arrays.asList(VK_SHIFT, VK_AMPERSAND)));
        CHARACTER_COMMANDS.put('(', Collections.unmodifiableList(Arrays.asList(VK_LEFT_PARENTHESIS)));
        CHARACTER_COMMANDS.put(')', Collections.unmodifiableList(Arrays.asList(VK_RIGHT_PARENTHESIS)));
        CHARACTER_COMMANDS.put('*', Collections.unmodifiableList(Arrays.asList(VK_SHIFT, VK_ASTERISK)));
        CHARACTER_COMMANDS.put('+', Collections.unmodifiableList(Arrays.asList(VK_PLUS)));
        CHARACTER_COMMANDS.put(',', Collections.unmodifiableList(Arrays.asList(VK_COMMA)));
        CHARACTER_COMMANDS.put('-', Collections.unmodifiableList(Arrays.asList(VK_MINUS)));
        CHARACTER_COMMANDS.put('.', Collections.unmodifiableList(Arrays.asList(VK_PERIOD)));
        CHARACTER_COMMANDS.put('/', Collections.unmodifiableList(Arrays.asList(VK_SLASH)));
        CHARACTER_COMMANDS.put('0', Collections.unmodifiableList(Arrays.asList(VK_0)));
        CHARACTER_COMMANDS.put('1', Collections.unmodifiableList(Arrays.asList(VK_1)));
        CHARACTER_COMMANDS.put('2', Collections.unmodifiableList(Arrays.asList(VK_2)));
        CHARACTER_COMMANDS.put('3', Collections.unmodifiableList(Arrays.asList(VK_3)));
        CHARACTER_COMMANDS.put('4', Collections.unmodifiableList(Arrays.asList(VK_4)));
        CHARACTER_COMMANDS.put('5', Collections.unmodifiableList(Arrays.asList(VK_5)));
        CHARACTER_COMMANDS.put('6', Collections.unmodifiableList(Arrays.asList(VK_6)));
        CHARACTER_COMMANDS.put('7', Collections.unmodifiableList(Arrays.asList(VK_7)));
        CHARACTER_COMMANDS.put('8', Collections.unmodifiableList(Arrays.asList(VK_8)));
        CHARACTER_COMMANDS.put('9', Collections.unmodifiableList(Arrays.asList(VK_9)));
        CHARACTER_COMMANDS.put(':', Collections.unmodifiableList(Arrays.asList(VK_SHIFT, VK_COLON)));
        CHARACTER_COMMANDS.put(';', Collections.unmodifiableList(Arrays.asList(VK_SEMICOLON)));
        CHARACTER_COMMANDS.put('<', Collections.unmodifiableList(Arrays.asList(VK_SHIFT, VK_COMMA)));
        CHARACTER_COMMANDS.put('=', Collections.unmodifiableList(Arrays.asList(VK_EQUALS)));
        CHARACTER_COMMANDS.put('>', Collections.unmodifiableList(Arrays.asList(VK_SHIFT, VK_PERIOD)));
        CHARACTER_COMMANDS.put('?', Collections.unmodifiableList(Arrays.asList(VK_SHIFT, VK_SLASH)));
        CHARACTER_COMMANDS.put('@', Collections.unmodifiableList(Arrays.asList(VK_SHIFT, VK_AT)));
        CHARACTER_COMMANDS.put('A', Collections.unmodifiableList(Arrays.asList(VK_SHIFT, VK_A)));
        CHARACTER_COMMANDS.put('B', Collections.unmodifiableList(Arrays.asList(VK_SHIFT, VK_B)));
        CHARACTER_COMMANDS.put('C', Collections.unmodifiableList(Arrays.asList(VK_SHIFT, VK_C)));
        CHARACTER_COMMANDS.put('D', Collections.unmodifiableList(Arrays.asList(VK_SHIFT, VK_D)));
        CHARACTER_COMMANDS.put('E', Collections.unmodifiableList(Arrays.asList(VK_SHIFT, VK_E)));
        CHARACTER_COMMANDS.put('F', Collections.unmodifiableList(Arrays.asList(VK_SHIFT, VK_F)));
        CHARACTER_COMMANDS.put('G', Collections.unmodifiableList(Arrays.asList(VK_SHIFT, VK_G)));
        CHARACTER_COMMANDS.put('H', Collections.unmodifiableList(Arrays.asList(VK_SHIFT, VK_H)));
        CHARACTER_COMMANDS.put('I', Collections.unmodifiableList(Arrays.asList(VK_SHIFT, VK_I)));
        CHARACTER_COMMANDS.put('J', Collections.unmodifiableList(Arrays.asList(VK_SHIFT, VK_J)));
        CHARACTER_COMMANDS.put('K', Collections.unmodifiableList(Arrays.asList(VK_SHIFT, VK_K)));
        CHARACTER_COMMANDS.put('L', Collections.unmodifiableList(Arrays.asList(VK_SHIFT, VK_L)));
        CHARACTER_COMMANDS.put('M', Collections.unmodifiableList(Arrays.asList(VK_SHIFT, VK_M)));
        CHARACTER_COMMANDS.put('N', Collections.unmodifiableList(Arrays.asList(VK_SHIFT, VK_N)));
        CHARACTER_COMMANDS.put('O', Collections.unmodifiableList(Arrays.asList(VK_SHIFT, VK_O)));
        CHARACTER_COMMANDS.put('P', Collections.unmodifiableList(Arrays.asList(VK_SHIFT, VK_P)));
        CHARACTER_COMMANDS.put('Q', Collections.unmodifiableList(Arrays.asList(VK_SHIFT, VK_Q)));
        CHARACTER_COMMANDS.put('R', Collections.unmodifiableList(Arrays.asList(VK_SHIFT, VK_R)));
        CHARACTER_COMMANDS.put('S', Collections.unmodifiableList(Arrays.asList(VK_SHIFT, VK_S)));
        CHARACTER_COMMANDS.put('T', Collections.unmodifiableList(Arrays.asList(VK_SHIFT, VK_T)));
        CHARACTER_COMMANDS.put('U', Collections.unmodifiableList(Arrays.asList(VK_SHIFT, VK_U)));
        CHARACTER_COMMANDS.put('V', Collections.unmodifiableList(Arrays.asList(VK_SHIFT, VK_V)));
        CHARACTER_COMMANDS.put('W', Collections.unmodifiableList(Arrays.asList(VK_SHIFT, VK_W)));
        CHARACTER_COMMANDS.put('X', Collections.unmodifiableList(Arrays.asList(VK_SHIFT, VK_X)));
        CHARACTER_COMMANDS.put('Y', Collections.unmodifiableList(Arrays.asList(VK_SHIFT, VK_Y)));
        CHARACTER_COMMANDS.put('Z', Collections.unmodifiableList(Arrays.asList(VK_SHIFT, VK_Z)));
        CHARACTER_COMMANDS.put('[', Collections.unmodifiableList(Arrays.asList(VK_OPEN_BRACKET)));
        CHARACTER_COMMANDS.put('\'', Collections.unmodifiableList(Arrays.asList(VK_QUOTE)));
        CHARACTER_COMMANDS.put('\\', Collections.unmodifiableList(Arrays.asList(VK_BACK_SLASH)));
        CHARACTER_COMMANDS.put('\n', Collections.unmodifiableList(Arrays.asList(VK_ENTER)));
        CHARACTER_COMMANDS.put('\t', Collections.unmodifiableList(Arrays.asList(VK_TAB)));
        CHARACTER_COMMANDS.put(']', Collections.unmodifiableList(Arrays.asList(VK_CLOSE_BRACKET)));
        CHARACTER_COMMANDS.put('^', Collections.unmodifiableList(Arrays.asList(VK_SHIFT, VK_CIRCUMFLEX)));
        CHARACTER_COMMANDS.put('_', Collections.unmodifiableList(Arrays.asList(VK_SHIFT, VK_UNDERSCORE)));
        CHARACTER_COMMANDS.put('`', Collections.unmodifiableList(Arrays.asList(VK_BACK_QUOTE)));
        CHARACTER_COMMANDS.put('a', Collections.unmodifiableList(Arrays.asList(VK_A)));
        CHARACTER_COMMANDS.put('b', Collections.unmodifiableList(Arrays.asList(VK_B)));
        CHARACTER_COMMANDS.put('c', Collections.unmodifiableList(Arrays.asList(VK_C)));
        CHARACTER_COMMANDS.put('d', Collections.unmodifiableList(Arrays.asList(VK_D)));
        CHARACTER_COMMANDS.put('e', Collections.unmodifiableList(Arrays.asList(VK_E)));
        CHARACTER_COMMANDS.put('f', Collections.unmodifiableList(Arrays.asList(VK_F)));
        CHARACTER_COMMANDS.put('g', Collections.unmodifiableList(Arrays.asList(VK_G)));
        CHARACTER_COMMANDS.put('h', Collections.unmodifiableList(Arrays.asList(VK_H)));
        CHARACTER_COMMANDS.put('i', Collections.unmodifiableList(Arrays.asList(VK_I)));
        CHARACTER_COMMANDS.put('j', Collections.unmodifiableList(Arrays.asList(VK_J)));
        CHARACTER_COMMANDS.put('k', Collections.unmodifiableList(Arrays.asList(VK_K)));
        CHARACTER_COMMANDS.put('l', Collections.unmodifiableList(Arrays.asList(VK_L)));
        CHARACTER_COMMANDS.put('m', Collections.unmodifiableList(Arrays.asList(VK_M)));
        CHARACTER_COMMANDS.put('n', Collections.unmodifiableList(Arrays.asList(VK_N)));
        CHARACTER_COMMANDS.put('o', Collections.unmodifiableList(Arrays.asList(VK_O)));
        CHARACTER_COMMANDS.put('p', Collections.unmodifiableList(Arrays.asList(VK_P)));
        CHARACTER_COMMANDS.put('q', Collections.unmodifiableList(Arrays.asList(VK_Q)));
        CHARACTER_COMMANDS.put('r', Collections.unmodifiableList(Arrays.asList(VK_R)));
        CHARACTER_COMMANDS.put('s', Collections.unmodifiableList(Arrays.asList(VK_S)));
        CHARACTER_COMMANDS.put('t', Collections.unmodifiableList(Arrays.asList(VK_T)));
        CHARACTER_COMMANDS.put('u', Collections.unmodifiableList(Arrays.asList(VK_U)));
        CHARACTER_COMMANDS.put('v', Collections.unmodifiableList(Arrays.asList(VK_V)));
        CHARACTER_COMMANDS.put('w', Collections.unmodifiableList(Arrays.asList(VK_W)));
        CHARACTER_COMMANDS.put('x', Collections.unmodifiableList(Arrays.asList(VK_X)));
        CHARACTER_COMMANDS.put('y', Collections.unmodifiableList(Arrays.asList(VK_Y)));
        CHARACTER_COMMANDS.put('z', Collections.unmodifiableList(Arrays.asList(VK_Z)));
        CHARACTER_COMMANDS.put('{', Collections.unmodifiableList(Arrays.asList(VK_SHIFT, VK_OPEN_BRACKET)));
        CHARACTER_COMMANDS.put('|', Collections.unmodifiableList(Arrays.asList(VK_SHIFT, VK_BACK_SLASH)));
        CHARACTER_COMMANDS.put('}', Collections.unmodifiableList(Arrays.asList(VK_SHIFT, VK_CLOSE_BRACKET)));
        CHARACTER_COMMANDS.put('~', Collections.unmodifiableList(Arrays.asList(VK_SHIFT, VK_BACK_QUOTE)));
    }

    private CharacterCommands() { /* Intentionally Empty */ }

    static List<Integer> getCommands(char pCharacter)
    {
        return Collections.unmodifiableList(CHARACTER_COMMANDS.get(pCharacter));
    }
}
