package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.def.db.id.PKAT_AppIdentifier;
import yuyu.def.db.mapping.GenAT_AppIdentifier;
import yuyu.def.db.meta.GenQAT_AppIdentifier;
import yuyu.def.db.meta.QAT_AppIdentifier;

/**
 * アプリケーション識別子管理テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenAT_AppIdentifier} の JavaDoc を参照してください。
 * @see     GenAT_AppIdentifier
 * @see     PKAT_AppIdentifier
 * @see     QAT_AppIdentifier
 * @see     GenQAT_AppIdentifier
 */
@Entity
public class AT_AppIdentifier extends GenAT_AppIdentifier {

    private static final long serialVersionUID = 1L;

    public AT_AppIdentifier() {
    }

    public AT_AppIdentifier(String pIdentifier) {
        super(pIdentifier);
    }

    @Override
    protected void prePersist() {
        // ※ AbstractExDBEntity#prePersist() をオーバーライドし、更新者ID・更新機能・更新時間 を自動的にセットさせないようにした。
        // 解説）
        //  AT_AppIdentifier (アプリケーション識別子管理テーブル) はタイマーにより定期的にリフレッシュされるテーブルで、
        //  業務アプリのリクエスト等で更新されるテーブルではない。
        //  タイマーで定期的にリフレッシュされるので、その時点では HttpServletRequest も HttpSession も存在しない。
        //  一方、base-pkg 用のテーブルは「システムで統一的に 更新者ID・更新機能・更新時間 を自動更新する」という方針で、
        //  その際 更新者ID・更新機能 の自動解決に HttpServletRequest や HttpSession を利用する。
        //  タイマーリフレッシュのタイミングでは HttpServletRequest も HttpSession も存在しないので、
        //  更新者ID・更新機能 を自動解決しようとした時に落ちる。
        //  これを解決するために当メソッドを Override して PrePersist ・ PreUpdate されないようにしている。
    }

    @Override
    protected void preUpdate() {
    }

}
