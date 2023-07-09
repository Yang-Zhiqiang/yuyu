CREATE TABLE MT_DsNeugokiHanteiKekka_Z (
     dsdatasakuseiymd                                   VARCHAR     (8)                                                       NOT NULL  ,  /* ＤＳデータ作成日 */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     dskokno                                            VARCHAR     (10)                                                                ,  /* ＤＳ顧客番号 */
     dsmailaddressrenban                                DECIMAL     (9)                                                                 ,  /* ＤＳメールアドレス連番 */
     kyknmkn                                            VARCHAR     (38)                                                                ,  /* 契約者名（カナ） */
     kykymd                                             VARCHAR     (8)                                                                 ,  /* 契約日 */
     bosyuujiaatukaidrtencd                             VARCHAR     (7)                                                                 ,  /* 募集時Ａ扱代理店コード */
     bosyuujibatukaidrtencd                             VARCHAR     (7)                                                                 ,  /* 募集時Ｂ扱代理店コード */
     aisyoumeikbn                                       VARCHAR     (3)                                                                 ,  /* 愛称名区分 */
     kyktuukasyu                                        VARCHAR     (3)                                                                 ,  /* 契約通貨種類 */
     kaiyakuhryen                                       DECIMAL     (13)                                                                ,  /* 解約返戻金（円貨） */
     kaiyakuhryen$                                      VARCHAR     (10)                                                                ,  /* 解約返戻金（円貨）(通貨型) */
     itijibrp                                           DECIMAL     (13)                                                                ,  /* 一時払保険料 */
     itijibrp$                                          VARCHAR     (10)                                                                ,  /* 一時払保険料(通貨型) */
     neugokihanteikjnkngk                               DECIMAL     (13)                                                                ,  /* 値動き判定基準金額 */
     neugokihanteikjnkngk$                              VARCHAR     (10)                                                                ,  /* 値動き判定基準金額(通貨型) */
     neugokiwari                                        DECIMAL     (3,2)                                                               ,  /* 値動き割合 */
     neugokitoutatulinefile                             DECIMAL     (3,2)                                                               ,  /* 値動き到達ライン（ファイル） */
     neugokitoutatulinemail                             DECIMAL     (3,2)                                                               ,  /* 値動き到達ライン（メール） */
     neugokihanteiumukbn                                VARCHAR     (1)                                                                 ,  /* 値動き判定有無区分 */
     mailsousinyhkbn                                    VARCHAR     (1)                                                                 ,  /* メール送信要否区分 */
     mailaddresstourokuumukbn                           VARCHAR     (1)                                                                 ,  /* メールアドレス登録有無区分 */
     dssousinno                                         VARCHAR     (21)                                                                ,  /* ＤＳ送信番号 */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                                /* バージョン */
)
;

ALTER TABLE MT_DsNeugokiHanteiKekka_Z ADD CONSTRAINT PK_DsNeugokiHanteiKekka PRIMARY KEY (
     dsdatasakuseiymd                                         , /* ＤＳデータ作成日 */
     syono                                                      /* 証券番号 */
) ;

CREATE INDEX IX1_DsNeugokiHanteiKekka ON MT_DsNeugokiHanteiKekka_Z (
     syono                                                      /* 証券番号 */
) ;
