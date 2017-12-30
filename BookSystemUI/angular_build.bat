set curpath=%cd%
set outputpaht=..\BookSystemBackstage\src\main\webapp\dist
call ng build -op=%outputpaht% -w
echo %outputpaht%