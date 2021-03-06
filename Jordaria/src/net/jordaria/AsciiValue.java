package net.jordaria;

/**
 * An enum of ascii characters and their integer value.
 * 
 * @author Ches Burks
 *
 */
public enum AsciiValue {
	A_LOWERCASE(97),
	B_LOWERCASE(98),
	C_LOWERCASE(99),
	D_LOWERCASE(100),
	E_LOWERCASE(101),
	F_LOWERCASE(102),
	G_LOWERCASE(103),
	H_LOWERCASE(104),
	I_LOWERCASE(105),
	J_LOWERCASE(106),
	K_LOWERCASE(107),
	L_LOWERCASE(108),
	M_LOWERCASE(109),
	N_LOWERCASE(110),
	O_LOWERCASE(111),
	P_LOWERCASE(112),
	Q_LOWERCASE(113),
	R_LOWERCASE(114),
	S_LOWERCASE(115),
	T_LOWERCASE(116),
	U_LOWERCASE(117),
	V_LOWERCASE(118),
	W_LOWERCASE(119),
	X_LOWERCASE(120),
	Y_LOWERCASE(121),
	Z_LOWERCASE(122),
	A_UPPERCASE(65),
	B_UPPERCASE(66),
	C_UPPERCASE(67),
	D_UPPERCASE(68),
	E_UPPERCASE(69),
	F_UPPERCASE(70),
	G_UPPERCASE(71),
	H_UPPERCASE(72),
	I_UPPERCASE(73),
	J_UPPERCASE(74),
	K_UPPERCASE(75),
	L_UPPERCASE(76),
	M_UPPERCASE(77),
	N_UPPERCASE(78),
	O_UPPERCASE(79),
	P_UPPERCASE(80),
	Q_UPPERCASE(81),
	R_UPPERCASE(82),
	S_UPPERCASE(83),
	T_UPPERCASE(84),
	U_UPPERCASE(85),
	V_UPPERCASE(86),
	W_UPPERCASE(87),
	X_UPPERCASE(88),
	Y_UPPERCASE(89),
	Z_UPPERCASE(90),
	NUMBER_0(48),
	NUMBER_1(49),
	NUMBER_2(50),
	NUMBER_3(51),
	NUMBER_4(52),
	NUMBER_5(53),
	NUMBER_6(54),
	NUMBER_7(55),
	NUMBER_8(56),
	NUMBER_9(57),
	SPACE(32),
	EXCLAMATION_MARK(33),
	QUOTATION_MARK(34),
	NUMBER_SIGN(35),
	DOLLAR_SIGN(36),
	PERCENT_SIGN(37),
	AMPERSAND(38),
	APOSTROPHE(39),
	PARENTHESES_OPEN(40),
	PARENTHESES_CLOSE(41),
	ASTERISK(42),
	PLUS(43),
	COMMA(44),
	MINUS(45),
	PERIOD(46),
	FORWARDSLASH(47),
	COLON(58),
	SEMICOLON(59),
	LESS_THAN(60),
	EQUALS(61),
	GREATER_THAN(62),
	QUESTION_MARK(63),
	AT_SIGN(64),
	SQUARE_BRACKET_OPEN(91),
	BACKSLASH(92),
	SQUARE_BRACKER_CLOSE(93),
	CARET(94),
	UNDERSCORE(95),
	OPEN_SINGLE_QUOTE(96),
	CURLY_BRACE_OPEN(123),
	VERTICAL_LINE(124),
	CURLY_BRACE_CLOSE(125),
	TILDE(126);


	private final int value;
	
	/**
	 * Constructs a new {@link AsciiValue} with the given value.
	 * 
	 * @param val The integer value of the character
	 */
	private AsciiValue(int val){
		this.value = val;
	}
	
	/**
	 * Returns the integer ASCII value for the character.
	 * 
	 * @return The value
	 */
	public int value(){
		return this.value;
	}
}
