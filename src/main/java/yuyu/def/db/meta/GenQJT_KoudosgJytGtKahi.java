package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_KdsgJyoutaiGaitouKbn;
import yuyu.def.classification.C_SysnJyoujiKaigoGaitouKbn;
import yuyu.def.db.entity.JT_KoudosgJytGtKahi;
import yuyu.def.db.type.UserType_C_KdsgJyoutaiGaitouKbn;
import yuyu.def.db.type.UserType_C_SysnJyoujiKaigoGaitouKbn;

/**
 * 高度障害状態該当可否テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQJT_KoudosgJytGtKahi extends AbstractExDBTable<JT_KoudosgJytGtKahi> {

    public GenQJT_KoudosgJytGtKahi() {
        this("JT_KoudosgJytGtKahi");
    }

    public GenQJT_KoudosgJytGtKahi(String pAlias) {
        super("JT_KoudosgJytGtKahi", JT_KoudosgJytGtKahi.class, pAlias);
    }

    public String JT_KoudosgJytGtKahi() {
        return getAliasExpression();
    }

    public final ExDBFieldString<JT_KoudosgJytGtKahi, String> skno = new ExDBFieldString<>("skno", this);

    public final ExDBFieldString<JT_KoudosgJytGtKahi, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldNumber<JT_KoudosgJytGtKahi, Integer> seikyuurirekino = new ExDBFieldNumber<>("seikyuurirekino", this);

    public final ExDBFieldString<JT_KoudosgJytGtKahi, C_KdsgJyoutaiGaitouKbn> ryougansitumeikbn = new ExDBFieldString<>("ryougansitumeikbn", this, UserType_C_KdsgJyoutaiGaitouKbn.class);

    public final ExDBFieldString<JT_KoudosgJytGtKahi, String> ryougansitumeicomment = new ExDBFieldString<>("ryougansitumeicomment", this);

    public final ExDBFieldString<JT_KoudosgJytGtKahi, C_KdsgJyoutaiGaitouKbn> gengososyakusousitukbn = new ExDBFieldString<>("gengososyakusousitukbn", this, UserType_C_KdsgJyoutaiGaitouKbn.class);

    public final ExDBFieldString<JT_KoudosgJytGtKahi, String> gengososyakusousitucomment = new ExDBFieldString<>("gengososyakusousitucomment", this);

    public final ExDBFieldString<JT_KoudosgJytGtKahi, C_KdsgJyoutaiGaitouKbn> ryoujyousiyoubousitukbn = new ExDBFieldString<>("ryoujyousiyoubousitukbn", this, UserType_C_KdsgJyoutaiGaitouKbn.class);

    public final ExDBFieldString<JT_KoudosgJytGtKahi, String> ryoujyousiyoubousitucomt = new ExDBFieldString<>("ryoujyousiyoubousitucomt", this);

    public final ExDBFieldString<JT_KoudosgJytGtKahi, C_KdsgJyoutaiGaitouKbn> ryoukasiyoubousitukbn = new ExDBFieldString<>("ryoukasiyoubousitukbn", this, UserType_C_KdsgJyoutaiGaitouKbn.class);

    public final ExDBFieldString<JT_KoudosgJytGtKahi, String> ryoukasiyoubousitucomt = new ExDBFieldString<>("ryoukasiyoubousitucomt", this);

    public final ExDBFieldString<JT_KoudosgJytGtKahi, C_KdsgJyoutaiGaitouKbn> ijyobosituikasiyositukbn = new ExDBFieldString<>("ijyobosituikasiyositukbn", this, UserType_C_KdsgJyoutaiGaitouKbn.class);

    public final ExDBFieldString<JT_KoudosgJytGtKahi, String> ijyobosituikasiyositucomt = new ExDBFieldString<>("ijyobosituikasiyositucomt", this);

    public final ExDBFieldString<JT_KoudosgJytGtKahi, C_KdsgJyoutaiGaitouKbn> ijyoyosituikasibositukbn = new ExDBFieldString<>("ijyoyosituikasibositukbn", this, UserType_C_KdsgJyoutaiGaitouKbn.class);

    public final ExDBFieldString<JT_KoudosgJytGtKahi, String> ijyoyosituikasibositucomt = new ExDBFieldString<>("ijyoyosituikasibositucomt", this);

    public final ExDBFieldString<JT_KoudosgJytGtKahi, C_KdsgJyoutaiGaitouKbn> sysnjoujikaigokbn = new ExDBFieldString<>("sysnjoujikaigokbn", this, UserType_C_KdsgJyoutaiGaitouKbn.class);

    public final ExDBFieldString<JT_KoudosgJytGtKahi, String> sysnjoujikaigocomment = new ExDBFieldString<>("sysnjoujikaigocomment", this);

    public final ExDBFieldString<JT_KoudosgJytGtKahi, C_SysnJyoujiKaigoGaitouKbn> hokoukbn = new ExDBFieldString<>("hokoukbn", this, UserType_C_SysnJyoujiKaigoGaitouKbn.class);

    public final ExDBFieldString<JT_KoudosgJytGtKahi, String> hokoucomment = new ExDBFieldString<>("hokoucomment", this);

    public final ExDBFieldString<JT_KoudosgJytGtKahi, C_SysnJyoujiKaigoGaitouKbn> ihukutyakudatukbn = new ExDBFieldString<>("ihukutyakudatukbn", this, UserType_C_SysnJyoujiKaigoGaitouKbn.class);

    public final ExDBFieldString<JT_KoudosgJytGtKahi, String> ihukutyakudatucomment = new ExDBFieldString<>("ihukutyakudatucomment", this);

    public final ExDBFieldString<JT_KoudosgJytGtKahi, C_SysnJyoujiKaigoGaitouKbn> nyuuyokukbn = new ExDBFieldString<>("nyuuyokukbn", this, UserType_C_SysnJyoujiKaigoGaitouKbn.class);

    public final ExDBFieldString<JT_KoudosgJytGtKahi, String> nyuuyokucomment = new ExDBFieldString<>("nyuuyokucomment", this);

    public final ExDBFieldString<JT_KoudosgJytGtKahi, C_SysnJyoujiKaigoGaitouKbn> syokumotusessyukbn = new ExDBFieldString<>("syokumotusessyukbn", this, UserType_C_SysnJyoujiKaigoGaitouKbn.class);

    public final ExDBFieldString<JT_KoudosgJytGtKahi, String> syokumotusessyucomment = new ExDBFieldString<>("syokumotusessyucomment", this);

    public final ExDBFieldString<JT_KoudosgJytGtKahi, C_SysnJyoujiKaigoGaitouKbn> hukitorisimatukbn = new ExDBFieldString<>("hukitorisimatukbn", this, UserType_C_SysnJyoujiKaigoGaitouKbn.class);

    public final ExDBFieldString<JT_KoudosgJytGtKahi, String> hukitorisimatucomment = new ExDBFieldString<>("hukitorisimatucomment", this);

    public final ExDBFieldString<JT_KoudosgJytGtKahi, C_SysnJyoujiKaigoGaitouKbn> haibenhainyoukbn = new ExDBFieldString<>("haibenhainyoukbn", this, UserType_C_SysnJyoujiKaigoGaitouKbn.class);

    public final ExDBFieldString<JT_KoudosgJytGtKahi, String> haibenhainyoucomment = new ExDBFieldString<>("haibenhainyoucomment", this);

    public final ExDBFieldString<JT_KoudosgJytGtKahi, C_SysnJyoujiKaigoGaitouKbn> kikyokbn = new ExDBFieldString<>("kikyokbn", this, UserType_C_SysnJyoujiKaigoGaitouKbn.class);

    public final ExDBFieldString<JT_KoudosgJytGtKahi, String> kikyocomment = new ExDBFieldString<>("kikyocomment", this);

    public final ExDBFieldString<JT_KoudosgJytGtKahi, String> kossyoricd = new ExDBFieldString<>("kossyoricd", this);

    public final ExDBFieldString<JT_KoudosgJytGtKahi, String> kossyorisscd = new ExDBFieldString<>("kossyorisscd", this);

    public final ExDBFieldString<JT_KoudosgJytGtKahi, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<JT_KoudosgJytGtKahi, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
