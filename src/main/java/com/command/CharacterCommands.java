package com.command;

import java.util.*;
import static java.awt.event.KeyEvent.*;

class CharacterCommands
{
    private static final Map<Character, List<Integer>> CHARACTER_COMMANDS = new HashMap<>();

    static
    {
        CHARACTER_COMMANDS.put(' ', List.of(VK_SPACE));
        CHARACTER_COMMANDS.put('!', List.of(VK_SHIFT, VK_EXCLAMATION_MARK));
        CHARACTER_COMMANDS.put('"', List.of(VK_SHIFT, VK_QUOTEDBL));
        CHARACTER_COMMANDS.put('#', List.of(VK_SHIFT, VK_NUMBER_SIGN));
        CHARACTER_COMMANDS.put('$', List.of(VK_SHIFT, VK_DOLLAR));
        CHARACTER_COMMANDS.put('%', List.of(VK_SHIFT, VK_5));
        CHARACTER_COMMANDS.put('&', List.of(VK_SHIFT, VK_AMPERSAND));
        CHARACTER_COMMANDS.put('(', List.of(VK_LEFT_PARENTHESIS));
        CHARACTER_COMMANDS.put(')', List.of(VK_RIGHT_PARENTHESIS));
        CHARACTER_COMMANDS.put('*', List.of(VK_SHIFT, VK_ASTERISK));
        CHARACTER_COMMANDS.put('+', List.of(VK_PLUS));
        CHARACTER_COMMANDS.put(',', List.of(VK_COMMA));
        CHARACTER_COMMANDS.put('-', List.of(VK_MINUS));
        CHARACTER_COMMANDS.put('.', List.of(VK_PERIOD));
        CHARACTER_COMMANDS.put('/', List.of(VK_SLASH));
        CHARACTER_COMMANDS.put('0', List.of(VK_0));
        CHARACTER_COMMANDS.put('1', List.of(VK_1));
        CHARACTER_COMMANDS.put('2', List.of(VK_2));
        CHARACTER_COMMANDS.put('3', List.of(VK_3));
        CHARACTER_COMMANDS.put('4', List.of(VK_4));
        CHARACTER_COMMANDS.put('5', List.of(VK_5));
        CHARACTER_COMMANDS.put('6', List.of(VK_6));
        CHARACTER_COMMANDS.put('7', List.of(VK_7));
        CHARACTER_COMMANDS.put('8', List.of(VK_8));
        CHARACTER_COMMANDS.put('9', List.of(VK_9));
        CHARACTER_COMMANDS.put(':', List.of(VK_SHIFT, VK_COLON));
        CHARACTER_COMMANDS.put(';', List.of(VK_SEMICOLON));
        CHARACTER_COMMANDS.put('<', List.of(VK_SHIFT, VK_COMMA));
        CHARACTER_COMMANDS.put('=', List.of(VK_EQUALS));
        CHARACTER_COMMANDS.put('>', List.of(VK_SHIFT, VK_PERIOD));
        CHARACTER_COMMANDS.put('?', List.of(VK_SHIFT, VK_SLASH));
        CHARACTER_COMMANDS.put('@', List.of(VK_SHIFT, VK_AT));
        CHARACTER_COMMANDS.put('A', List.of(VK_SHIFT, VK_A));
        CHARACTER_COMMANDS.put('B', List.of(VK_SHIFT, VK_B));
        CHARACTER_COMMANDS.put('C', List.of(VK_SHIFT, VK_C));
        CHARACTER_COMMANDS.put('D', List.of(VK_SHIFT, VK_D));
        CHARACTER_COMMANDS.put('E', List.of(VK_SHIFT, VK_E));
        CHARACTER_COMMANDS.put('F', List.of(VK_SHIFT, VK_F));
        CHARACTER_COMMANDS.put('G', List.of(VK_SHIFT, VK_G));
        CHARACTER_COMMANDS.put('H', List.of(VK_SHIFT, VK_H));
        CHARACTER_COMMANDS.put('I', List.of(VK_SHIFT, VK_I));
        CHARACTER_COMMANDS.put('J', List.of(VK_SHIFT, VK_J));
        CHARACTER_COMMANDS.put('K', List.of(VK_SHIFT, VK_K));
        CHARACTER_COMMANDS.put('L', List.of(VK_SHIFT, VK_L));
        CHARACTER_COMMANDS.put('M', List.of(VK_SHIFT, VK_M));
        CHARACTER_COMMANDS.put('N', List.of(VK_SHIFT, VK_N));
        CHARACTER_COMMANDS.put('O', List.of(VK_SHIFT, VK_O));
        CHARACTER_COMMANDS.put('P', List.of(VK_SHIFT, VK_P));
        CHARACTER_COMMANDS.put('Q', List.of(VK_SHIFT, VK_Q));
        CHARACTER_COMMANDS.put('R', List.of(VK_SHIFT, VK_R));
        CHARACTER_COMMANDS.put('S', List.of(VK_SHIFT, VK_S));
        CHARACTER_COMMANDS.put('T', List.of(VK_SHIFT, VK_T));
        CHARACTER_COMMANDS.put('U', List.of(VK_SHIFT, VK_U));
        CHARACTER_COMMANDS.put('V', List.of(VK_SHIFT, VK_V));
        CHARACTER_COMMANDS.put('W', List.of(VK_SHIFT, VK_W));
        CHARACTER_COMMANDS.put('X', List.of(VK_SHIFT, VK_X));
        CHARACTER_COMMANDS.put('Y', List.of(VK_SHIFT, VK_Y));
        CHARACTER_COMMANDS.put('Z', List.of(VK_SHIFT, VK_Z));
        CHARACTER_COMMANDS.put('[', List.of(VK_OPEN_BRACKET));
        CHARACTER_COMMANDS.put('\'', List.of(VK_QUOTE));
        CHARACTER_COMMANDS.put('\\', List.of(VK_BACK_SLASH));
        CHARACTER_COMMANDS.put('\n', List.of(VK_ENTER));
        CHARACTER_COMMANDS.put('\t', List.of(VK_TAB));
        CHARACTER_COMMANDS.put(']', List.of(VK_CLOSE_BRACKET));
        CHARACTER_COMMANDS.put('^', List.of(VK_SHIFT, VK_CIRCUMFLEX));
        CHARACTER_COMMANDS.put('_', List.of(VK_SHIFT, VK_UNDERSCORE));
        CHARACTER_COMMANDS.put('`', List.of(VK_BACK_QUOTE));
        CHARACTER_COMMANDS.put('a', List.of(VK_A));
        CHARACTER_COMMANDS.put('b', List.of(VK_B));
        CHARACTER_COMMANDS.put('c', List.of(VK_C));
        CHARACTER_COMMANDS.put('d', List.of(VK_D));
        CHARACTER_COMMANDS.put('e', List.of(VK_E));
        CHARACTER_COMMANDS.put('f', List.of(VK_F));
        CHARACTER_COMMANDS.put('g', List.of(VK_G));
        CHARACTER_COMMANDS.put('h', List.of(VK_H));
        CHARACTER_COMMANDS.put('i', List.of(VK_I));
        CHARACTER_COMMANDS.put('j', List.of(VK_J));
        CHARACTER_COMMANDS.put('k', List.of(VK_K));
        CHARACTER_COMMANDS.put('l', List.of(VK_L));
        CHARACTER_COMMANDS.put('m', List.of(VK_M));
        CHARACTER_COMMANDS.put('n', List.of(VK_N));
        CHARACTER_COMMANDS.put('o', List.of(VK_O));
        CHARACTER_COMMANDS.put('p', List.of(VK_P));
        CHARACTER_COMMANDS.put('q', List.of(VK_Q));
        CHARACTER_COMMANDS.put('r', List.of(VK_R));
        CHARACTER_COMMANDS.put('s', List.of(VK_S));
        CHARACTER_COMMANDS.put('t', List.of(VK_T));
        CHARACTER_COMMANDS.put('u', List.of(VK_U));
        CHARACTER_COMMANDS.put('v', List.of(VK_V));
        CHARACTER_COMMANDS.put('w', List.of(VK_W));
        CHARACTER_COMMANDS.put('x', List.of(VK_X));
        CHARACTER_COMMANDS.put('y', List.of(VK_Y));
        CHARACTER_COMMANDS.put('z', List.of(VK_Z));
        CHARACTER_COMMANDS.put('{', List.of(VK_SHIFT, VK_OPEN_BRACKET));
        CHARACTER_COMMANDS.put('|', List.of(VK_SHIFT, VK_BACK_SLASH));
        CHARACTER_COMMANDS.put('}', List.of(VK_SHIFT, VK_CLOSE_BRACKET));
        CHARACTER_COMMANDS.put('~', List.of(VK_SHIFT, VK_BACK_QUOTE));
    }

    private CharacterCommands() { /* Intentionally Empty */ }

    static List<Integer> getCommands(char pCharacter)
    {
        return CHARACTER_COMMANDS.get(pCharacter);
    }
}
