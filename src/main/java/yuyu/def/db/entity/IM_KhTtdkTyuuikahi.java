package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.classification.C_TtdktyuuiKbn;
import yuyu.def.db.mapping.GenIM_KhTtdkTyuuikahi;


/**
 * 契約保全手続注意処理可否マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIM_KhTtdkTyuuikahi} の JavaDoc を参照してください。<br />
 * @see     GenIM_KhTtdkTyuuikahi<br />
 * @see     PKIM_KhTtdkTyuuikahi<br />
 * @see     QIM_KhTtdkTyuuikahi<br />
 * @see     GenQIM_KhTtdkTyuuikahi<br />
 */
@Entity
public class IM_KhTtdkTyuuikahi extends GenIM_KhTtdkTyuuikahi {

    private static final long serialVersionUID = 1L;

    public IM_KhTtdkTyuuikahi() {
    }

    public IM_KhTtdkTyuuikahi(String pKinouId,C_TtdktyuuiKbn pTtdktyuuikbn) {
        super(pKinouId,pTtdktyuuikbn);
    }



}

