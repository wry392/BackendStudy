package study.study.common.status

enum class Gender(val desc: String) {
    MAN("남"),
    WOMAN("여")
}

// 추가
enum class ResultCode(val msg: String) {
    SUCCESS("정상 처리 되었습니다."),
    ERROR("에러가 발생했습니다.")
}

enum class Dorm(val desc: String) {
    GOUNA("고운A"),
    GOUNB("고운B"),
    GOUNC("고운C"),
    GYEONGSANG11("경상11"),
    GYEONGSANG12("경상12"),
    GYEONGSANG13("경상13"),
    GYEONGSANG14("경상14")
}

enum class ROLE {
    MEMBER
}
