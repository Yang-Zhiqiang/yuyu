package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.classification.C_UktkSyoriKbn;
import yuyu.def.db.mapping.GenIM_KhHenkouUktksyorikahi;

/**
 * 契約保全変更受付中処理可否マスタ エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIM_KhHenkouUktksyorikahi} の JavaDoc を参照してください。
 * @see     GenIM_KhHenkouUktksyorikahi
 * @see     PKIM_KhHenkouUktksyorikahi
 * @see     QIM_KhHenkouUktksyorikahi
 * @see     GenQIM_KhHenkouUktksyorikahi
 */
@Entity
public class IM_KhHenkouUktksyorikahi extends GenIM_KhHenkouUktksyorikahi {

    private static final long serialVersionUID = 1L;

    public IM_KhHenkouUktksyorikahi() {
    }

    public IM_KhHenkouUktksyorikahi(String pKinouId,C_UktkSyoriKbn pUktksyorikbn) {
        super(pKinouId,pUktksyorikbn);
    }



}

