CREATE TABLE IT_Suiihyou_Z (
     kbnkey                                             VARCHAR     (2)                                                       NOT NULL  ,  /* 区分キー */
     syono                                              VARCHAR     (20)                                                      NOT NULL  ,  /* 証券番号 */
     tyouhyouymd                                        VARCHAR     (8)                                                       NOT NULL  ,  /* 帳票作成日 */
     keikanensuu                                        DECIMAL     (2)                                                       NOT NULL  ,  /* 経過年数 */
     calckijyunymd                                      VARCHAR     (8)                                                                 ,  /* 計算基準日 */
     calcym                                             VARCHAR     (6)                                                                 ,  /* 計算年月 */
     mvatekijyoutaikbn                                  VARCHAR     (1)                                                                 ,  /* ＭＶＡ適用状態区分 */
     kyktuukasyu                                        VARCHAR     (3)                                                                 ,  /* 契約通貨種類 */
     sjkkktusirrtup                                     DECIMAL     (5,4)                                                               ,  /* 市場価格調整用利率（上昇） */
     sjkkktusirrtsame                                   DECIMAL     (5,4)                                                               ,  /* 市場価格調整用利率（同水準） */
     sjkkktusirrtdown                                   DECIMAL     (5,4)                                                               ,  /* 市場価格調整用利率（低下） */
     sjkkktusirrthendouup                               DECIMAL     (5,4)                                                               ,  /* 市場価格調整用利率変動幅（上） */
     sjkkktusirrthendoudown                             DECIMAL     (5,4)                                                               ,  /* 市場価格調整用利率変動幅（下） */
     yenknsnkwsrateyendaka                              DECIMAL     (7,4)                                                               ,  /* 円換算適用為替レート（円高） */
     yenknsnkwsrateyenkijyun                            DECIMAL     (7,4)                                                               ,  /* 円換算適用為替レート（中央値） */
     yenknsnkwsrateyenyasu                              DECIMAL     (7,4)                                                               ,  /* 円換算適用為替レート（円安） */
     yenknsnkwsrategkyendaka                            DECIMAL     (10)                                                                ,  /* 円換算適用為替レート変動額（円高） */
     yenknsnkwsrategkyendaka$                           VARCHAR     (10)                                                                ,  /* 円換算適用為替レート変動額（円高）(通貨型) */
     yenknsnkwsrategkyenyasu                            DECIMAL     (10)                                                                ,  /* 円換算適用為替レート変動額（円安） */
     yenknsnkwsrategkyenyasu$                           VARCHAR     (10)                                                                ,  /* 円換算適用為替レート変動額（円安）(通貨型) */
     mvaariwup                                          DECIMAL     (13)                                                                ,  /* ＭＶＡ適用解約返戻金額（上昇） */
     mvaariwup$                                         VARCHAR     (10)                                                                ,  /* ＭＶＡ適用解約返戻金額（上昇）(通貨型) */
     mvaariwsame                                        DECIMAL     (13)                                                                ,  /* ＭＶＡ適用解約返戻金額（同水準） */
     mvaariwsame$                                       VARCHAR     (10)                                                                ,  /* ＭＶＡ適用解約返戻金額（同水準）(通貨型) */
     mvaariwdown                                        DECIMAL     (13)                                                                ,  /* ＭＶＡ適用解約返戻金額（低下） */
     mvaariwdown$                                       VARCHAR     (10)                                                                ,  /* ＭＶＡ適用解約返戻金額（低下）(通貨型) */
     mvaariwyenupyendaka                                DECIMAL     (13)                                                                ,  /* ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高） */
     mvaariwyenupyendaka$                               VARCHAR     (10)                                                                ,  /* ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）(通貨型) */
     mvaariwyenupyenkijyun                              DECIMAL     (13)                                                                ,  /* ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値） */
     mvaariwyenupyenkijyun$                             VARCHAR     (10)                                                                ,  /* ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）(通貨型) */
     mvaariwyenupyenyasu                                DECIMAL     (13)                                                                ,  /* ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安） */
     mvaariwyenupyenyasu$                               VARCHAR     (10)                                                                ,  /* ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）(通貨型) */
     mvaariwyensameyendaka                              DECIMAL     (13)                                                                ,  /* ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高） */
     mvaariwyensameyendaka$                             VARCHAR     (10)                                                                ,  /* ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）(通貨型) */
     mvaariwyensameyenkijyun                            DECIMAL     (13)                                                                ,  /* ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値） */
     mvaariwyensameyenkijyun$                           VARCHAR     (10)                                                                ,  /* ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）(通貨型) */
     mvaariwyensameyenyasu                              DECIMAL     (13)                                                                ,  /* ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安） */
     mvaariwyensameyenyasu$                             VARCHAR     (10)                                                                ,  /* ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）(通貨型) */
     mvaariwyendownyendaka                              DECIMAL     (13)                                                                ,  /* ＭＶＡ適用解約返戻金額（円貨）（低下）（円高） */
     mvaariwyendownyendaka$                             VARCHAR     (10)                                                                ,  /* ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）(通貨型) */
     mvaariwyendownyenkijyun                            DECIMAL     (13)                                                                ,  /* ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値） */
     mvaariwyendownyenkijyun$                           VARCHAR     (10)                                                                ,  /* ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）(通貨型) */
     mvaariwyendownyenyasu                              DECIMAL     (13)                                                                ,  /* ＭＶＡ適用解約返戻金額（円貨）（低下）（円安） */
     mvaariwyendownyenyasu$                             VARCHAR     (10)                                                                ,  /* ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）(通貨型) */
     mvaariptumitatekin                                 DECIMAL     (13)                                                                ,  /* ＭＶＡ適用保険料積立金 */
     mvaariptumitatekin$                                VARCHAR     (10)                                                                ,  /* ＭＶＡ適用保険料積立金(通貨型) */
     mvanonewsame                                       DECIMAL     (13)                                                                ,  /* ＭＶＡ適用外解約返戻金額 */
     mvanonewsame$                                      VARCHAR     (10)                                                                ,  /* ＭＶＡ適用外解約返戻金額(通貨型) */
     mvanonewyensameyendaka                             DECIMAL     (13)                                                                ,  /* ＭＶＡ適用外解約返戻金額（円貨）（円高） */
     mvanonewyensameyendaka$                            VARCHAR     (10)                                                                ,  /* ＭＶＡ適用外解約返戻金額（円貨）（円高）(通貨型) */
     mvanonewyensameyenkijyun                           DECIMAL     (13)                                                                ,  /* ＭＶＡ適用外解約返戻金額（円貨）（中央値） */
     mvanonewyensameyenkijyun$                          VARCHAR     (10)                                                                ,  /* ＭＶＡ適用外解約返戻金額（円貨）（中央値）(通貨型) */
     mvanonewyensameyenyasu                             DECIMAL     (13)                                                                ,  /* ＭＶＡ適用外解約返戻金額（円貨）（円安） */
     mvanonewyensameyenyasu$                            VARCHAR     (10)                                                                ,  /* ＭＶＡ適用外解約返戻金額（円貨）（円安）(通貨型) */
     mvanoneptumitatekin                                DECIMAL     (13)                                                                ,  /* ＭＶＡ適用外保険料積立金 */
     mvanoneptumitatekin$                               VARCHAR     (10)                                                                ,  /* ＭＶＡ適用外保険料積立金(通貨型) */
     mkhyouyensysnikougk                                DECIMAL     (13)                                                                ,  /* 目標到達時円建終身保険移行特約目標額 */
     mkhyouyensysnikougk$                               VARCHAR     (10)                                                                ,  /* 目標到達時円建終身保険移行特約目標額(通貨型) */
     gyoumuKousinKinou                                  VARCHAR     (50)                                                                ,  /* 業務用更新機能ＩＤ */
     gyoumuKousinsyaId                                  VARCHAR     (15)                                                                ,  /* 業務用更新者ＩＤ */
     gyoumuKousinTime                                   VARCHAR     (17)                                                                ,  /* 業務用更新時間 */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL WITH DEFAULT 0                                             ,  /* バージョン */
     tmttknzoukaritu1                                   DECIMAL     (5,4)                                                               ,  /* 積立金増加率１ */
     tmttknzoukaritu2                                   DECIMAL     (5,4)                                                               ,  /* 積立金増加率２ */
     tmttknzoukaritu3                                   DECIMAL     (5,4)                                                               ,  /* 積立金増加率３ */
     sjkkktusirrtup2                                    DECIMAL     (5,4)                                                               ,  /* 市場価格調整用利率（上昇）２ */
     sjkkktusirrtsame2                                  DECIMAL     (5,4)                                                               ,  /* 市場価格調整用利率（同水準）２ */
     sjkkktusirrtdown2                                  DECIMAL     (5,4)                                                               ,  /* 市場価格調整用利率（低下）２ */
     sjkkktusirrthendouup2                              DECIMAL     (5,4)                                                               ,  /* 市場価格調整用利率変動幅（上）２ */
     sjkkktusirrthendoudown2                            DECIMAL     (5,4)                                                               ,  /* 市場価格調整用利率変動幅（下）２ */
     yenknsnkwsrateyendaka2                             DECIMAL     (7,4)                                                               ,  /* 円換算適用為替レート（円高）２ */
     yenknsnkwsrateyenkijyun2                           DECIMAL     (7,4)                                                               ,  /* 円換算適用為替レート（中央値）２ */
     yenknsnkwsrateyenyasu2                             DECIMAL     (7,4)                                                               ,  /* 円換算適用為替レート（円安）２ */
     yenknsnkwsrategkyendaka2                           DECIMAL     (10)                                                                ,  /* 円換算適用為替レート変動額（円高）２ */
     yenknsnkwsrategkyendaka2$                          VARCHAR     (10)                                                                ,  /* 円換算適用為替レート変動額（円高）２(通貨型) */
     yenknsnkwsrategkyenyasu2                           DECIMAL     (10)                                                                ,  /* 円換算適用為替レート変動額（円安）２ */
     yenknsnkwsrategkyenyasu2$                          VARCHAR     (10)                                                                ,  /* 円換算適用為替レート変動額（円安）２(通貨型) */
     mvaariwup2                                         DECIMAL     (13)                                                                ,  /* ＭＶＡ適用解約返戻金額（上昇）２ */
     mvaariwup2$                                        VARCHAR     (10)                                                                ,  /* ＭＶＡ適用解約返戻金額（上昇）２(通貨型) */
     mvaariwsame2                                       DECIMAL     (13)                                                                ,  /* ＭＶＡ適用解約返戻金額（同水準）２ */
     mvaariwsame2$                                      VARCHAR     (10)                                                                ,  /* ＭＶＡ適用解約返戻金額（同水準）２(通貨型) */
     mvaariwdown2                                       DECIMAL     (13)                                                                ,  /* ＭＶＡ適用解約返戻金額（低下）２ */
     mvaariwdown2$                                      VARCHAR     (10)                                                                ,  /* ＭＶＡ適用解約返戻金額（低下）２(通貨型) */
     mvaariwyenupyendaka2                               DECIMAL     (13)                                                                ,  /* ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）２ */
     mvaariwyenupyendaka2$                              VARCHAR     (10)                                                                ,  /* ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）２(通貨型) */
     mvaariwyenupyenkijyun2                             DECIMAL     (13)                                                                ,  /* ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）２ */
     mvaariwyenupyenkijyun2$                            VARCHAR     (10)                                                                ,  /* ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）２(通貨型) */
     mvaariwyenupyenyasu2                               DECIMAL     (13)                                                                ,  /* ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）２ */
     mvaariwyenupyenyasu2$                              VARCHAR     (10)                                                                ,  /* ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）２(通貨型) */
     mvaariwyensameyendaka2                             DECIMAL     (13)                                                                ,  /* ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）２ */
     mvaariwyensameyendaka2$                            VARCHAR     (10)                                                                ,  /* ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）２(通貨型) */
     mvaariwyensameyenkijyun2                           DECIMAL     (13)                                                                ,  /* ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）２ */
     mvaariwyensameyenkijyun2$                          VARCHAR     (10)                                                                ,  /* ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）２(通貨型) */
     mvaariwyensameyenyasu2                             DECIMAL     (13)                                                                ,  /* ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）２ */
     mvaariwyensameyenyasu2$                            VARCHAR     (10)                                                                ,  /* ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）２(通貨型) */
     mvaariwyendownyendaka2                             DECIMAL     (13)                                                                ,  /* ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）２ */
     mvaariwyendownyendaka2$                            VARCHAR     (10)                                                                ,  /* ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）２(通貨型) */
     mvaariwyendownyenkijyun2                           DECIMAL     (13)                                                                ,  /* ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）２ */
     mvaariwyendownyenkijyun2$                          VARCHAR     (10)                                                                ,  /* ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）２(通貨型) */
     mvaariwyendownyenyasu2                             DECIMAL     (13)                                                                ,  /* ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）２ */
     mvaariwyendownyenyasu2$                            VARCHAR     (10)                                                                ,  /* ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）２(通貨型) */
     mvaariptumitatekin2                                DECIMAL     (13)                                                                ,  /* ＭＶＡ適用保険料積立金２ */
     mvaariptumitatekin2$                               VARCHAR     (10)                                                                ,  /* ＭＶＡ適用保険料積立金２(通貨型) */
     mvanonewsame2                                      DECIMAL     (13)                                                                ,  /* ＭＶＡ適用外解約返戻金額２ */
     mvanonewsame2$                                     VARCHAR     (10)                                                                ,  /* ＭＶＡ適用外解約返戻金額２(通貨型) */
     mvanonewyensameyendaka2                            DECIMAL     (13)                                                                ,  /* ＭＶＡ適用外解約返戻金額（円貨）（円高）２ */
     mvanonewyensameyendaka2$                           VARCHAR     (10)                                                                ,  /* ＭＶＡ適用外解約返戻金額（円貨）（円高）２(通貨型) */
     mvanonewyensameyenkijyun2                          DECIMAL     (13)                                                                ,  /* ＭＶＡ適用外解約返戻金額（円貨）（中央値）２ */
     mvanonewyensameyenkijyun2$                         VARCHAR     (10)                                                                ,  /* ＭＶＡ適用外解約返戻金額（円貨）（中央値）２(通貨型) */
     mvanonewyensameyenyasu2                            DECIMAL     (13)                                                                ,  /* ＭＶＡ適用外解約返戻金額（円貨）（円安）２ */
     mvanonewyensameyenyasu2$                           VARCHAR     (10)                                                                ,  /* ＭＶＡ適用外解約返戻金額（円貨）（円安）２(通貨型) */
     mvanoneptumitatekin2                               DECIMAL     (13)                                                                ,  /* ＭＶＡ適用外保険料積立金２ */
     mvanoneptumitatekin2$                              VARCHAR     (10)                                                                ,  /* ＭＶＡ適用外保険料積立金２(通貨型) */
     sjkkktusirrtup3                                    DECIMAL     (5,4)                                                               ,  /* 市場価格調整用利率（上昇）３ */
     sjkkktusirrtsame3                                  DECIMAL     (5,4)                                                               ,  /* 市場価格調整用利率（同水準）３ */
     sjkkktusirrtdown3                                  DECIMAL     (5,4)                                                               ,  /* 市場価格調整用利率（低下）３ */
     sjkkktusirrthendouup3                              DECIMAL     (5,4)                                                               ,  /* 市場価格調整用利率変動幅（上）３ */
     sjkkktusirrthendoudown3                            DECIMAL     (5,4)                                                               ,  /* 市場価格調整用利率変動幅（下）３ */
     yenknsnkwsrateyendaka3                             DECIMAL     (7,4)                                                               ,  /* 円換算適用為替レート（円高）３ */
     yenknsnkwsrateyenkijyun3                           DECIMAL     (7,4)                                                               ,  /* 円換算適用為替レート（中央値）３ */
     yenknsnkwsrateyenyasu3                             DECIMAL     (7,4)                                                               ,  /* 円換算適用為替レート（円安）３ */
     yenknsnkwsrategkyendaka3                           DECIMAL     (10)                                                                ,  /* 円換算適用為替レート変動額（円高）３ */
     yenknsnkwsrategkyendaka3$                          VARCHAR     (10)                                                                ,  /* 円換算適用為替レート変動額（円高）３(通貨型) */
     yenknsnkwsrategkyenyasu3                           DECIMAL     (10)                                                                ,  /* 円換算適用為替レート変動額（円安）３ */
     yenknsnkwsrategkyenyasu3$                          VARCHAR     (10)                                                                ,  /* 円換算適用為替レート変動額（円安）３(通貨型) */
     mvaariwup3                                         DECIMAL     (13)                                                                ,  /* ＭＶＡ適用解約返戻金額（上昇）３ */
     mvaariwup3$                                        VARCHAR     (10)                                                                ,  /* ＭＶＡ適用解約返戻金額（上昇）３(通貨型) */
     mvaariwsame3                                       DECIMAL     (13)                                                                ,  /* ＭＶＡ適用解約返戻金額（同水準）３ */
     mvaariwsame3$                                      VARCHAR     (10)                                                                ,  /* ＭＶＡ適用解約返戻金額（同水準）３(通貨型) */
     mvaariwdown3                                       DECIMAL     (13)                                                                ,  /* ＭＶＡ適用解約返戻金額（低下）３ */
     mvaariwdown3$                                      VARCHAR     (10)                                                                ,  /* ＭＶＡ適用解約返戻金額（低下）３(通貨型) */
     mvaariwyenupyendaka3                               DECIMAL     (13)                                                                ,  /* ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）３ */
     mvaariwyenupyendaka3$                              VARCHAR     (10)                                                                ,  /* ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）３(通貨型) */
     mvaariwyenupyenkijyun3                             DECIMAL     (13)                                                                ,  /* ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）３ */
     mvaariwyenupyenkijyun3$                            VARCHAR     (10)                                                                ,  /* ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）３(通貨型) */
     mvaariwyenupyenyasu3                               DECIMAL     (13)                                                                ,  /* ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）３ */
     mvaariwyenupyenyasu3$                              VARCHAR     (10)                                                                ,  /* ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）３(通貨型) */
     mvaariwyensameyendaka3                             DECIMAL     (13)                                                                ,  /* ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）３ */
     mvaariwyensameyendaka3$                            VARCHAR     (10)                                                                ,  /* ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）３(通貨型) */
     mvaariwyensameyenkijyun3                           DECIMAL     (13)                                                                ,  /* ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）３ */
     mvaariwyensameyenkijyun3$                          VARCHAR     (10)                                                                ,  /* ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）３(通貨型) */
     mvaariwyensameyenyasu3                             DECIMAL     (13)                                                                ,  /* ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）３ */
     mvaariwyensameyenyasu3$                            VARCHAR     (10)                                                                ,  /* ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）３(通貨型) */
     mvaariwyendownyendaka3                             DECIMAL     (13)                                                                ,  /* ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）３ */
     mvaariwyendownyendaka3$                            VARCHAR     (10)                                                                ,  /* ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）３(通貨型) */
     mvaariwyendownyenkijyun3                           DECIMAL     (13)                                                                ,  /* ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）３ */
     mvaariwyendownyenkijyun3$                          VARCHAR     (10)                                                                ,  /* ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）３(通貨型) */
     mvaariwyendownyenyasu3                             DECIMAL     (13)                                                                ,  /* ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）３ */
     mvaariwyendownyenyasu3$                            VARCHAR     (10)                                                                ,  /* ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）３(通貨型) */
     mvaariptumitatekin3                                DECIMAL     (13)                                                                ,  /* ＭＶＡ適用保険料積立金３ */
     mvaariptumitatekin3$                               VARCHAR     (10)                                                                ,  /* ＭＶＡ適用保険料積立金３(通貨型) */
     mvanonewsame3                                      DECIMAL     (13)                                                                ,  /* ＭＶＡ適用外解約返戻金額３ */
     mvanonewsame3$                                     VARCHAR     (10)                                                                ,  /* ＭＶＡ適用外解約返戻金額３(通貨型) */
     mvanonewyensameyendaka3                            DECIMAL     (13)                                                                ,  /* ＭＶＡ適用外解約返戻金額（円貨）（円高）３ */
     mvanonewyensameyendaka3$                           VARCHAR     (10)                                                                ,  /* ＭＶＡ適用外解約返戻金額（円貨）（円高）３(通貨型) */
     mvanonewyensameyenkijyun3                          DECIMAL     (13)                                                                ,  /* ＭＶＡ適用外解約返戻金額（円貨）（中央値）３ */
     mvanonewyensameyenkijyun3$                         VARCHAR     (10)                                                                ,  /* ＭＶＡ適用外解約返戻金額（円貨）（中央値）３(通貨型) */
     mvanonewyensameyenyasu3                            DECIMAL     (13)                                                                ,  /* ＭＶＡ適用外解約返戻金額（円貨）（円安）３ */
     mvanonewyensameyenyasu3$                           VARCHAR     (10)                                                                ,  /* ＭＶＡ適用外解約返戻金額（円貨）（円安）３(通貨型) */
     mvanoneptumitatekin3                               DECIMAL     (13)                                                                ,  /* ＭＶＡ適用外保険料積立金３ */
     mvanoneptumitatekin3$                              VARCHAR     (10)                                                                ,  /* ＭＶＡ適用外保険料積立金３(通貨型) */
     tutmttknutiwake11                                  DECIMAL     (13)                                                                ,  /* 積立金内訳（１）１ */
     tutmttknutiwake11$                                 VARCHAR     (10)                                                                ,  /* 積立金内訳（１）１(通貨型) */
     tutmttknutiwake21                                  DECIMAL     (13)                                                                ,  /* 積立金内訳（２）１ */
     tutmttknutiwake21$                                 VARCHAR     (10)                                                                ,  /* 積立金内訳（２）１(通貨型) */
     tutmttknutiwake12                                  DECIMAL     (13)                                                                ,  /* 積立金内訳（１）２ */
     tutmttknutiwake12$                                 VARCHAR     (10)                                                                ,  /* 積立金内訳（１）２(通貨型) */
     tutmttknutiwake22                                  DECIMAL     (13)                                                                ,  /* 積立金内訳（２）２ */
     tutmttknutiwake22$                                 VARCHAR     (10)                                                                ,  /* 積立金内訳（２）２(通貨型) */
     tutmttknutiwake13                                  DECIMAL     (13)                                                                ,  /* 積立金内訳（１）３ */
     tutmttknutiwake13$                                 VARCHAR     (10)                                                                ,  /* 積立金内訳（１）３(通貨型) */
     tutmttknutiwake23                                  DECIMAL     (13)                                                                ,  /* 積立金内訳（２）３ */
     tutmttknutiwake23$                                 VARCHAR     (10)                                                                ,  /* 積立金内訳（２）３(通貨型) */
     sisuuupritu1                                       DECIMAL     (5,4)                                                               ,  /* 指数上昇率１ */
     sisuuupritu2                                       DECIMAL     (5,4)                                                               ,  /* 指数上昇率２ */
     sisuuupritu3                                       DECIMAL     (5,4)                                                               ,  /* 指数上昇率３ */
     mvaaritmttkgkkykkjmaeup1                           DECIMAL     (13)                                                                ,  /* ＭＶＡ適用積立金額（解約控除前）（上昇）１ */
     mvaaritmttkgkkykkjmaeup1$                          VARCHAR     (10)                                                                ,  /* ＭＶＡ適用積立金額（解約控除前）（上昇）１(通貨型) */
     mvaaritmttkgkkykkjmaeup2                           DECIMAL     (13)                                                                ,  /* ＭＶＡ適用積立金額（解約控除前）（上昇）２ */
     mvaaritmttkgkkykkjmaeup2$                          VARCHAR     (10)                                                                ,  /* ＭＶＡ適用積立金額（解約控除前）（上昇）２(通貨型) */
     mvaaritmttkgkkykkjmaeup3                           DECIMAL     (13)                                                                ,  /* ＭＶＡ適用積立金額（解約控除前）（上昇）３ */
     mvaaritmttkgkkykkjmaeup3$                          VARCHAR     (10)                                                                ,  /* ＭＶＡ適用積立金額（解約控除前）（上昇）３(通貨型) */
     mvaaritmttkgkkykkjmaesame1                         DECIMAL     (13)                                                                ,  /* ＭＶＡ適用積立金額（解約控除前）（同水準）１ */
     mvaaritmttkgkkykkjmaesame1$                        VARCHAR     (10)                                                                ,  /* ＭＶＡ適用積立金額（解約控除前）（同水準）１(通貨型) */
     mvaaritmttkgkkykkjmaesame2                         DECIMAL     (13)                                                                ,  /* ＭＶＡ適用積立金額（解約控除前）（同水準）２ */
     mvaaritmttkgkkykkjmaesame2$                        VARCHAR     (10)                                                                ,  /* ＭＶＡ適用積立金額（解約控除前）（同水準）２(通貨型) */
     mvaaritmttkgkkykkjmaesame3                         DECIMAL     (13)                                                                ,  /* ＭＶＡ適用積立金額（解約控除前）（同水準）３ */
     mvaaritmttkgkkykkjmaesame3$                        VARCHAR     (10)                                                                ,  /* ＭＶＡ適用積立金額（解約控除前）（同水準）３(通貨型) */
     mvaaritmttkgkkykkjmaedown1                         DECIMAL     (13)                                                                ,  /* ＭＶＡ適用積立金額（解約控除前）（低下）１ */
     mvaaritmttkgkkykkjmaedown1$                        VARCHAR     (10)                                                                ,  /* ＭＶＡ適用積立金額（解約控除前）（低下）１(通貨型) */
     mvaaritmttkgkkykkjmaedown2                         DECIMAL     (13)                                                                ,  /* ＭＶＡ適用積立金額（解約控除前）（低下）２ */
     mvaaritmttkgkkykkjmaedown2$                        VARCHAR     (10)                                                                ,  /* ＭＶＡ適用積立金額（解約控除前）（低下）２(通貨型) */
     mvaaritmttkgkkykkjmaedown3                         DECIMAL     (13)                                                                ,  /* ＭＶＡ適用積立金額（解約控除前）（低下）３ */
     mvaaritmttkgkkykkjmaedown3$                        VARCHAR     (10)                                                                ,  /* ＭＶＡ適用積立金額（解約控除前）（低下）３(通貨型) */
     suiihyousyubetu                                    VARCHAR     (2)                                                                 ,  /* 推移表種別 */
     hrkkknmnryumukbn                                   VARCHAR     (1)                                                                 ,  /* 払込期間満了有無区分 */
     ytirrtcalckijyunrrt1                               DECIMAL     (5,4)                                                               ,  /* 予定利率計算基準利率１ */
     ytirrtcalckijyunrrt2                               DECIMAL     (5,4)                                                               ,  /* 予定利率計算基準利率２ */
     ytirrtcalckijyunrrt3                               DECIMAL     (5,4)                                                               ,  /* 予定利率計算基準利率３ */
     zennouzndkyen1                                     DECIMAL     (13)                                                                ,  /* 前納残高（円貨）１ */
     zennouzndkyen1$                                    VARCHAR     (10)                                                                ,  /* 前納残高（円貨）１(通貨型) */
     zennouzndkyen2                                     DECIMAL     (13)                                                                ,  /* 前納残高（円貨）２ */
     zennouzndkyen2$                                    VARCHAR     (10)                                                                ,  /* 前納残高（円貨）２(通貨型) */
     zennouzndkyen3                                     DECIMAL     (13)                                                                ,  /* 前納残高（円貨）３ */
     zennouzndkyen3$                                    VARCHAR     (10)                                                                ,  /* 前納残高（円貨）３(通貨型) */
     kihrkmpyen1                                        DECIMAL     (13)                                                                ,  /* 既払込保険料（円貨）１ */
     kihrkmpyen1$                                       VARCHAR     (10)                                                                ,  /* 既払込保険料（円貨）１(通貨型) */
     kihrkmpyen2                                        DECIMAL     (13)                                                                ,  /* 既払込保険料（円貨）２ */
     kihrkmpyen2$                                       VARCHAR     (10)                                                                ,  /* 既払込保険料（円貨）２(通貨型) */
     kihrkmpyen3                                        DECIMAL     (13)                                                                ,  /* 既払込保険料（円貨）３ */
     kihrkmpyen3$                                       VARCHAR     (10)                                                                ,  /* 既払込保険料（円貨）３(通貨型) */
     kihrkmp1                                           DECIMAL     (13)                                                                ,  /* 既払込保険料１ */
     kihrkmp1$                                          VARCHAR     (10)                                                                ,  /* 既払込保険料１(通貨型) */
     kihrkmp2                                           DECIMAL     (13)                                                                ,  /* 既払込保険料２ */
     kihrkmp2$                                          VARCHAR     (10)                                                                ,  /* 既払込保険料２(通貨型) */
     kihrkmp3                                           DECIMAL     (13)                                                                ,  /* 既払込保険料３ */
     kihrkmp3$                                          VARCHAR     (10)                                                                   /* 既払込保険料３(通貨型) */
)
;

ALTER TABLE IT_Suiihyou_Z ADD CONSTRAINT PK_Suiihyou PRIMARY KEY (
     kbnkey                                                   , /* 区分キー */
     syono                                                    , /* 証券番号 */
     tyouhyouymd                                              , /* 帳票作成日 */
     keikanensuu                                                /* 経過年数 */
) ;

CREATE INDEX IX1_Suiihyou ON IT_Suiihyou_Z (
     syono                                                    , /* 証券番号 */
     tyouhyouymd                                              , /* 帳票作成日 */
     keikanensuu                                                /* 経過年数 */
) ;

CREATE INDEX IX2_Suiihyou ON IT_Suiihyou_Z (
     tyouhyouymd                                                /* 帳票作成日 */
) ;
