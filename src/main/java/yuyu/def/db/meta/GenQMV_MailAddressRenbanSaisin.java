package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.MV_MailAddressRenbanSaisin;

/**
 * ＤＳメールアドレス連番最新ビュー のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQMV_MailAddressRenbanSaisin extends AbstractExDBTable<MV_MailAddressRenbanSaisin> {

    public GenQMV_MailAddressRenbanSaisin() {
        this("MV_MailAddressRenbanSaisin");
    }

    public GenQMV_MailAddressRenbanSaisin(String pAlias) {
        super("MV_MailAddressRenbanSaisin", MV_MailAddressRenbanSaisin.class, pAlias);
    }

    public String MV_MailAddressRenbanSaisin() {
        return getAliasExpression();
    }

    public final ExDBFieldString<MV_MailAddressRenbanSaisin, String> dskokno = new ExDBFieldString<>("dskokno", this);

    public final ExDBFieldNumber<MV_MailAddressRenbanSaisin, Integer> dsmailaddressrenban = new ExDBFieldNumber<>("dsmailaddressrenban", this);
}
