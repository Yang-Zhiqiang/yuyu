package yuyu.def.db.entity;

import javax.persistence.Entity;
import yuyu.def.db.id.PKIT_AnsyuyouErrJyouhou;
import yuyu.def.db.mapping.GenIT_AnsyuyouErrJyouhou;
import yuyu.def.db.meta.GenQIT_AnsyuyouErrJyouhou;
import yuyu.def.db.meta.QIT_AnsyuyouErrJyouhou;
import jp.co.slcs.swak.date.BizDate;

/**
 * 案内収納用エラー情報テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_AnsyuyouErrJyouhou} の JavaDoc を参照してください。
 * @see     GenIT_AnsyuyouErrJyouhou
 * @see     PKIT_AnsyuyouErrJyouhou
 * @see     QIT_AnsyuyouErrJyouhou
 * @see     GenQIT_AnsyuyouErrJyouhou
 */
@Entity
public class IT_AnsyuyouErrJyouhou extends GenIT_AnsyuyouErrJyouhou {

    private static final long serialVersionUID = 1L;

    public IT_AnsyuyouErrJyouhou() {
    }

    public IT_AnsyuyouErrJyouhou(
        BizDate pSyoriYmd,
        String pKakutyoujobcd,
        String pSyono,
        String pGyoumuKousinTime,
        String pAnsyuyouerrnaiyou
    ) {
        super(
            pSyoriYmd,
            pKakutyoujobcd,
            pSyono,
            pGyoumuKousinTime,
            pAnsyuyouerrnaiyou
        );
    }

}
