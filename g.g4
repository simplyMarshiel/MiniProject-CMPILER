grammar g;

prule: expression;
expression: expression PLUS term | expression MINUS term | term;
term: term MULT factor | term DIV factor | term MOD factor | factor;
factor: NUMBER | LPAREN expression RPAREN;

fragment DIGIT: [0-9];
NUMBER: '-'?DIGIT+;

MULT: '*';
DIV: '/';
MOD: '%';
PLUS: '+';
MINUS: '-';

LPAREN: '(';
RPAREN: ')';

COMMENT: '/*' .*? '*/' -> skip;
LINE_COMMENT: '//' ~[\r\n]* -> skip;
WHITE_SPACE: ' ' -> skip;
NEW_LINE: '\n' -> skip;
ESC_CHAR: '\r' -> skip;


