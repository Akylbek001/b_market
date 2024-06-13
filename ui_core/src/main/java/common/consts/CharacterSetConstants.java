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

    public static final String CLIENT_ALREADY_EXIST = "Клиент с ИИН 900901300432 уже существует";
    public static final String CLIENT_AGE_IS_NOT_SUITABLE = "Возраст клиента не подходит для продолжения операции по открытию счета НФД";
    public static final String INVALID_IIN_FORMAT = "ИИН имеет неверный формат";
    public static final String IIN_FILLED_INCORRECTLY = "Не правильно заполнен ИИН";
    public static final String EMAIL_UPDATED_TEXT = "Ваш e-mail успешно обновлен";
    public static final String PASSWORD_UPDATED = "Ваш пароль успешно обновлен";
    public static final String NEW_PASSWORD_SAME_WITH_CURRENT = "Новый пароль совпадает с текущим";
    public static final String PASSWORD_CONFIRM_ERROR_TEXT = "Пароли не совпадают";
    public static final String INVALID_EMAIL_FORMAT_TEXT = "Вы ввели некорректный e-mail";

    public static final String FEEDBACK_SENT_SUCCESSFULLY = "";
    public static final String CALLBACK_SUCCESS_TEXT = "Заявка успешно отправлена";
    public static final String CALLBACK_REFUSED_TEXT = "Оставьте свои данные, и мы перезвоним вам в рабочее время";
    public static final String GUEST_LOGIN_ALREADY_EXIST = "Пользователь с номером +77014640909 уже зарегистрирован";
    public static final String GUEST_EMAIL_ALREADY_EXIST = "Пользователь с email адресом: guest.kz@mail.ru- уже зарегистрирован в системе. Забыли пароль ?";
    public static final String CLIENT_LOGIN_ALREADY_EXIST = "Пользователь с номером +77477172709 уже зарегистрирован";
    public static final String CLIENT_EMAIL_ALREADY_EXIST = "Пользователь с email адресом: akylbekalibek9@gmail.com- уже зарегистрирован в системе. Забыли пароль ?";
    public static final String INVALID_FIO = "Нельзя вводить символы в ФИО";
    public static final String INVALID_PASS_CONFIRMATION = "Пароли не совпадают";
    public static final String INVALID_EMAIL = "Некорректный email";
    public static final String TITLE_TEXT_IN_KAZAKH = "Сіздің жылжымайтын мүлік бойынша гидіңіз";
    public static final String SELECTED_LOCATION = "ВКО";

    public static final String PHONE_NUMBER_ALREADY_CURRENT = "Көрсетілген телефон нөмірі қазірдің өзінде ағымдағы. / Указанный телефон уже актуален.";
    public static final String CURRENT_ACCOUNT_OPEN_REFUSED = "Уважаемый клиент! Вам отказано, так как вы находитесь в базе бездействующих налогоплательщиков, подробнее можете узнать по номеру 300";

}
