CREATE TABLE IT_SeihowebMizuhoMinyuuDtl_Z (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     drtencd                                            VARCHAR     (7)                                                       NOT NULL  ,  /* 代理店コード */
     bosyuucd                                           VARCHAR     (6)                                                       NOT NULL  ,  /* 募集人コード */
     syoriym                                            VARCHAR     (6)                                                       NOT NULL  ,  /* 処理年月 */
     minyusyoriymd                                      VARCHAR     (8)                                                                 ,  /* 未入処理日 */
     bosyuuym                                           VARCHAR     (6)                                                                 ,  /* 募集年月 */
     kydatkikbnkj                                       VARCHAR     (4)                                                                 ,  /* 共同扱区分（漢字） */
     kyknm35keta                                        VARCHAR     (72)                                                                ,  /* 契約者名（３５桁） */
     cifcd                                              VARCHAR     (15)                                                                ,  /* ＣＩＦコード */
     pjytym                                             VARCHAR     (6)                                                                 ,  /* 保険料充当年月 */
     atesakinm                                          VARCHAR     (42)                                                                ,  /* 宛先名 */
     minyujytymdyofuri                                  VARCHAR     (32)                                                                ,  /* 未入充当年月（預振） */
     minyujytymdyofuriigi                               VARCHAR     (22)                                                                ,  /* 未入充当年月（預振以外） */
     hassinka                                           VARCHAR     (64)                                                                ,  /* 発信課 */
     telno                                              VARCHAR     (32)                                                                ,  /* 電話番号 */
     tntnm10keta                                        VARCHAR     (22)                                                                ,  /* 担当者名（１０桁） */
     hrkkaisuukj                                        VARCHAR     (8)                                                                 ,  /* 払込回数（漢字） */
     hrkkeirokj                                         VARCHAR     (8)                                                                 ,  /* 払込経路（漢字） */
     hrkp                                               DECIMAL     (13)                                                                ,  /* 払込保険料 */
     hrkp$                                              VARCHAR     (10)                                                                ,  /* 払込保険料(通貨型) */
     knkimnyuuryu                                       VARCHAR     (12)                                                                ,  /* 今回未入理由 */
     jikaiminyuuji                                      VARCHAR     (12)                                                                ,  /* 次回未入時 */
     tntusygyouhaiinfo                                  VARCHAR     (10)                                                                ,  /* 担当者業廃情報 */
     hrkkeirobtjhmidasi                                 VARCHAR     (12)                                                                ,  /* 払込経路別情報見出し */
     hrkkeirobtjh                                       VARCHAR     (122)                                                               ,  /* 払込経路別情報 */
     hknsyuruinm30keta                                  VARCHAR     (62)                                                                ,  /* 保険種類名（３０桁） */
     drtenkanrisosikicd                                 VARCHAR     (7)                                                                 ,  /* 代理店管理組織コード */
     dbskyoteiym                                        VARCHAR     (6)                                                                 ,  /* ＤＢ削除予定年月 */
     keiyakuymd                                         VARCHAR     (8)                                                                 ,  /* 契約年月日 */
     hhknnmkj                                           VARCHAR     (32)                                                                ,  /* 被保険者名（漢字） */
     tsintelno                                          VARCHAR     (14)                                                                ,  /* 通信先電話番号 */
     dai2tsintelno                                      VARCHAR     (14)                                                                ,  /* 第２通信先電話番号 */
     bankcd                                             VARCHAR     (4)                                                                 ,  /* 銀行コード */
     sitencd                                            VARCHAR     (3)                                                                 ,  /* 支店コード */
     yokinkbn                                           VARCHAR     (1)                                                                 ,  /* 預金種目区分 */
     kouzano                                            VARCHAR     (12)                                                                ,  /* 口座番号 */
     hrkkaisuu                                          VARCHAR     (2)                                                                 ,  /* 払込回数 */
     hukkatukanoukknmnryymd                             VARCHAR     (8)                                                                 ,  /* 復活可能期間満了年月日 */
     hjnkykhyj                                          VARCHAR     (1)                                                                 ,  /* 法人契約表示 */
     kykjyutikbn                                        VARCHAR     (1)                                                                 ,  /* 契約状態区分 */
     tsinkihontikucd                                    VARCHAR     (8)                                                                 ,  /* 通信先基本地区コード */
     kanjitsinkaiadr                                    VARCHAR     (126)                                                               ,  /* 漢字通信先下位住所 */
     kzmeiginmkn                                        VARCHAR     (62)                                                                ,  /* 口座名義人氏名（カナ） */
     jkiannaikg                                         DECIMAL     (13)                                                                ,  /* 次回案内金額 */
     jkiannaikg$                                        VARCHAR     (10)                                                                ,  /* 次回案内金額(通貨型) */
     yykknmnryymd                                       VARCHAR     (8)                                                                 ,  /* 猶予期間満了日 */
     skymd                                              VARCHAR     (8)                                                                 ,  /* 失効年月日 */
     jhurikstkkahikbn                                   VARCHAR     (1)                                                                 ,  /* 自動振替貸付可否区分 */
     hukkatumoskahikbn                                  VARCHAR     (1)                                                                 ,  /* 復活申込可否区分 */
     ttdkkigenymd                                       VARCHAR     (8)                                                                 ,  /* 手続き期限年月日 */
     keikamon3keta                                      DECIMAL     (3)                                                                 ,  /* 経過月数（３桁） */
     misyuuhasseiym                                     VARCHAR     (6)                                                                 ,  /* 未収発生年月 */
     misyuujiyuu                                        VARCHAR     (2)                                                                 ,  /* 未収事由 */
     nexthurikaeymd                                     VARCHAR     (8)                                                                 ,  /* 次回振替日 */
     ikkatubaraikbn                                     VARCHAR     (1)                                                                 ,  /* 一括払区分 */
     ikkatubaraikaisuu                                  VARCHAR     (2)                                                                 ,  /* 一括払回数 */
     bosyuudairitengyousyukbn                           VARCHAR     (2)                                                                 ,  /* 募集代理店業種区分 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE IT_SeihowebMizuhoMinyuuDtl_Z ADD CONSTRAINT PK_SeihowebMizuhoMinyuuDtl PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                    , /* 証券番号 */
     drtencd                                                  , /* 代理店コード */
     bosyuucd                                                 , /* 募集人コード */
     syoriym                                                    /* 処理年月 */
) ;
