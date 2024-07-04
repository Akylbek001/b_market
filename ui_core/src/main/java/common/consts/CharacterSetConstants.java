package common.consts;

public final class CharacterSetConstants {
    public static final String ENGLISH_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvqxyz";
    public static final String RUSSIAN_ALPHABET = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    public static final String KAZAKH_ALPHABET = "АӘБВГҒДЕЁЖЗИЙКҚЛМНҢОӨПРСТУҰҮФХҺЦЧШЩЪЫІЬЭЮЯаәбвгғдеёжзийкқлмнңоөпрстуұүфхһцчшщъыіьэюя";
    public static final String NUMERIC = "0123456789";
    public static final String SPEC_CHARS = ",./?'|][{}()-_=+*&^:;#@$%\"";
    public static final String ALL_CHARS = ENGLISH_ALPHABET + NUMERIC + SPEC_CHARS;
    public static final String ALL_CHARS_AND_RUSSIAN = ENGLISH_ALPHABET + NUMERIC + SPEC_CHARS+RUSSIAN_ALPHABET;
    public static final String CLIENT_NAME = "NurRaul";
    public static final String GUEST_NAME = "Alibek";

    public static final String INVALID_CLIENT_NAME_OR_PASSWORD = "Указанные имя пользователя или пароль не верны.";
    public static final String INVALID_GUEST_NAME_OR_PASSWORD = "Пароль или логин не совпадает";

    public static final String UNEXPECTED_ERROR = "Возникла непредвиденная ошибка";
    public static final String USER_WITH_SUCH_DATA_NOT_FOUND = "Пользователь с такими данными не найден";
    public static final String INVALID_CODE = "Код не прошел проверку";
    public static final String IDENTITY_VERIFICATION_ERROR_TEXT = "Вы не прошли проверку подлинности личности";

    public static final String CLIENT_ALREADY_EXIST = "Клиент с ИИН 960327300186 уже существует";
    public static final String CLIENT_NUMBER_ALREADY_EXIST = "Клиент с номером телефона +77770770707 уже существует. Проверьте правильность введенного номера или зайдите в свой личный кабинет.";
    public static final String UNDER_18_YEARS_OLD_TEXT = "Вам нет 18 лет";
    public static final String CLIENT_AGE_IS_NOT_SUITABLE = "Возраст клиента не подходит для продолжения операции по открытию счета НФД";
    public static final String INVALID_IIN_FORMAT = "ИИН имеет неверный формат";
    public static final String IIN_FILLED_INCORRECTLY = "Не правильно заполнен ИИН";
    public static final String NOT_IN_TAX_AUTHORITY_DATABASE_TEXT= "Указанный Вами ИИН 960327300180 отсутствует в базе налогового органа. Проверьте корректность ИИН и повторите попытку или обратитесь в налоговый орган по месту регистрации";

    public static final String EMAIL_UPDATED_TEXT = "Ваш e-mail успешно обновлен";
    public static final String PASSWORD_UPDATED = "Ваш пароль успешно обновлен";
    public static final String NEW_PASSWORD_SAME_WITH_CURRENT = "Новый пароль совпадает с текущим";
    public static final String PASSWORD_CONFIRM_ERROR_TEXT = "Пароли не совпадают";
    public static final String PASSWORDS_MUST_NOT_BE_SAME = "Старый и новый пароль не должны совпадать";
    public static final String PASSWORDS_MUST_CONTAIN_AT_LEAST_ONE_NUMBER = "Пароль должен содержать хотябы одну цифру";
    public static final String PASSWORDS_MUST_CONTAIN_AT_LEAST_ONE_CAPITAL_LETTER = "Пароль должен содержать хотябы одну заглавную букву";
    public static final String PASSWORDS_MUST_CONTAIN_AT_LEAST_ONE_CHARACTER = "Пароль должен содержать хотябы один символ";
    public static final String INVALID_EMAIL_FORMAT_TEXT = "Вы ввели некорректный e-mail";

    public static final String CALLBACK_SUCCESS_TEXT = "Заявка успешно отправлена";
    public static final String CALLBACK_REFUSED_TEXT = "Оставьте свои данные, и мы перезвоним вам в рабочее время";
    public static final String GUEST_LOGIN_ALREADY_EXIST = "Пользователь с номером +77014640909 уже зарегистрирован";
    public static final String GUEST_EMAIL_ALREADY_EXIST = "Пользователь с email адресом: guest.kz@mail.ru- уже зарегистрирован в системе. Забыли пароль ?";
    public static final String CLIENT_LOGIN_ALREADY_EXIST = "Пользователь с номером +77477172709 уже зарегистрирован";
    public static final String CLIENT_EMAIL_ALREADY_EXIST = "Пользователь с email адресом: akylbekalibek9@gmail.com- уже зарегистрирован в системе. Забыли пароль ?";
    public static final String CLIENT_NOT_FOUND = "Пользователь по номеру документа не найден";
    public static final String CLIENT_NOT_FOUND_CHECK_NUMBER = "Клиент не найден, проверьте номер телефона";
    public static final String CLIENT_NOT_FOUND_CHECK_CODE = "Клиент не найден, проверьте введенный код";

    public static final String INVALID_FIO = "Нельзя вводить символы в ФИО";
    public static final String INVALID_PASS_CONFIRMATION = "Пароли не совпадают";
    public static final String INVALID_EMAIL = "Некорректный email";
    public static final String TITLE_TEXT_IN_KAZAKH = "Сіздің жылжымайтын мүлік бойынша гидіңіз";
    public static final String SELECTED_LOCATION = "ВКО";

    public static final String PHONE_NUMBER_ALREADY_CURRENT = "Көрсетілген телефон нөмірі қазірдің өзінде ағымдағы. / Указанный телефон уже актуален.";
    public static final String OPERATION_REFUSED = "Уважаемый клиент! Вам отказано, так как вы находитесь в базе бездействующих налогоплательщиков, подробнее можете узнать по номеру 300";
    public static final String ACTIVE_ORDER_FOR_DIVISION_MESSAGE ="Извините но у Вас уже есть актуальная заявка на деление вклада. Подробнее о заявке вы можете посмотреть во вкладке 'Заявки'.";
    public static final String INVALID_OTP_TEXT = "Уважаемый клиент! Убедитесь в правильности ввода кода из SMS";
    public static final String EPV_INVALID_OTP_TEXT = "Введенный вами код из СМС неправильный.";
    public static final String INVALID_IBAN = "Вы ввели некорректный IBAN счет!";
    public static final String INSUFFICIENT_FUNDS_FOR_TRANSFER = "Недостаточно средств для перевода";

    public static final String CURRENT_ACCOUNT_OPEN_SUCCESSFULLY_TEXT ="Операция успешно завершена";
    public static final String OPEN_DEPOSIT_REFUSED = "Уважаемый клиент! Вам необходимо обратиться в отделение банка";
    public static final String INVALID_INVITED_MEMBER_ALTERNATIVE_CODE = "Уважаемый клиент! Введенный Вами альтернативный код некорректный, просим проверить данные.";
    public static final String VALIDATION_OF_REGISTRATION = "Уважаемый клиент! В семейный пакет включаются только зарегистрированные клиенты в Интернет банкинге/мобильном приложений, необходимо проверить наличие регистрации.";
    public static final String RELATION_DEGREE_NOT_SELECTED_TEXT = "Уважаемый клиент! Выберите степень родства";
    public static final String NEED_TO_OPEN_CURRENT_ACCOUNT_TEXT = "Для продолжения операции Вам необходимо открыть текущий счет, далее необходимо обеспечить наличии минимального взноса в размере 3 МРП.";
    public static final String CERTIFICATE_HAS_BEEN_GENERATED = "Справка сформирована";
    public static final String STATEMENT_HAS_BEEN_GENERATED = "Выписка сформирована";

    public static final String INSUFFICIENT_FOUND_TEXT = "Недостаточно средств на текущем счете";
    public static final String GOS_PREM_ALREADY_EXIST_TEXT = "На выбранном депозите уже присутствует государственная премия";
    public static final String REQUEST_BEEN_ACCEPTED_TEXT = "Рахмет! Сіздің өтінішіңіз қабылданды. Поштаңызға өтініш туралы хабарлама жіберілді.";
    public static final String DEPOSIT_DIVISION_ACCEPTED = "Ваша заявка на деление депозита принята";
    public static final String DEPOSIT_DIVISION_NEED_TO_OPEN_ACCOUNT_VALIDATION = "Для деления депозита Вам необходимо открыть текущий счет. Поскольку на этот счет будет произведен перевод денежных средств с делимого депозита";
    public static final String DEPOSIT_DIVISION_SAVING_AMOUNT_VALIDATION = "Уважаемый клиент! Минимальная сумма накопления должна быть больше 50 МРП";

    public static final String ONLY_ONE_DEPOSIT = "У вас недостаточное количество депозитов для совершения операции объединения";
    public static final String DEPOSIT_AMOUNT_MUST_BE_BETWEEN = "Договорная сумма должна быть между: 1846000,0₸ - 195154000,0₸";
    public static final String DEPOSIT_CONDITIONS_CHANGED_SUCCESSFULLY_TEXT ="Операция завершилась успешно";
    public static final String REQUEST_ACCEPTED_TEXT ="Ваша заявка на расторжение депозита принята";
    public static final String NOT_READY_TO_ACCEPT_REQUEST_TEXT = "Выбранный акимат еще не готов принять заявление";
    public static final String SERVICE_NOT_AVAILABLE = "Изивините, сервис временно недоступен! Повторите попытку позже";
}
