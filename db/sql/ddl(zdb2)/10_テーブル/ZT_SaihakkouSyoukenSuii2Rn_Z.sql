CREATE TABLE ZT_SaihakkouSyoukenSuii2Rn_Z (
     zrnsyono                                           CHAR        (11)                                                      NOT NULL  ,  /* （連携用）証券番号 */
     zrntyouhyouymd                                     CHAR        (8)                                                       NOT NULL  ,  /* （連携用）帳票作成日 */
     zrnsuiihyouptn                                     CHAR        (2)                                                       NOT NULL  ,  /* （連携用）推移表パターン */
     zrnsuiihyousykbn                                   CHAR        (2)                                                       NOT NULL  ,  /* （連携用）推移表種別区分 */
     zrnsuiihyousyono                                   CHAR        (11)                                                      NOT NULL  ,  /* （連携用）推移表証券番号 */
     zrnytirrtcalckijyunrrt                             GRAPHIC     (5)                                                       NOT NULL  ,  /* （連携用）予定利率計算基準利率 */
     zrnwkwsrateyendaka                                 CHAR        (5)                                                       NOT NULL  ,  /* （連携用）解約返戻金為替レート（円高） */
     zrnwkwsrateyenkijyun                               CHAR        (5)                                                       NOT NULL  ,  /* （連携用）解約返戻金為替レート（中央値） */
     zrnwkwsrateyenyasu                                 CHAR        (5)                                                       NOT NULL  ,  /* （連携用）解約返戻金為替レート（円安） */
     zrnkyktuukatype                                    CHAR        (3)                                                       NOT NULL  ,  /* （連携用）契約通貨タイプ */
     zrnnenoutouym01                                    GRAPHIC     (8)                                                       NOT NULL  ,  /* （連携用）年単位応当年月０１ */
     zrnhrkkknmnryumukbn01                              CHAR        (1)                                                       NOT NULL  ,  /* （連携用）払込期間満了有無区分０１ */
     zrnzennouzndkyen01                                 CHAR        (13)                                                      NOT NULL  ,  /* （連携用）前納残高（円貨）０１ */
     zrnyenhrkgkgoukei01                                CHAR        (13)                                                      NOT NULL  ,  /* （連携用）円貨払込額の合計（円貨）０１ */
     zrnkihrkmp01                                       CHAR        (13)                                                      NOT NULL  ,  /* （連携用）既払込保険料０１ */
     zrnw01                                             CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金０１ */
     zrnwyenyendaka01                                   CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金（円貨）円高０１ */
     zrnwyenkijun01                                     CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金（円貨）中央値０１ */
     zrnwyenyenyasu01                                   CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金（円貨）円安０１ */
     zrnnenoutouym02                                    GRAPHIC     (8)                                                       NOT NULL  ,  /* （連携用）年単位応当年月０２ */
     zrnhrkkknmnryumukbn02                              CHAR        (1)                                                       NOT NULL  ,  /* （連携用）払込期間満了有無区分０２ */
     zrnzennouzndkyen02                                 CHAR        (13)                                                      NOT NULL  ,  /* （連携用）前納残高（円貨）０２ */
     zrnyenhrkgkgoukei02                                CHAR        (13)                                                      NOT NULL  ,  /* （連携用）円貨払込額の合計（円貨）０２ */
     zrnkihrkmp02                                       CHAR        (13)                                                      NOT NULL  ,  /* （連携用）既払込保険料０２ */
     zrnw02                                             CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金０２ */
     zrnwyenyendaka02                                   CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金（円貨）円高０２ */
     zrnwyenkijun02                                     CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金（円貨）中央値０２ */
     zrnwyenyenyasu02                                   CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金（円貨）円安０２ */
     zrnnenoutouym03                                    GRAPHIC     (8)                                                       NOT NULL  ,  /* （連携用）年単位応当年月０３ */
     zrnhrkkknmnryumukbn03                              CHAR        (1)                                                       NOT NULL  ,  /* （連携用）払込期間満了有無区分０３ */
     zrnzennouzndkyen03                                 CHAR        (13)                                                      NOT NULL  ,  /* （連携用）前納残高（円貨）０３ */
     zrnyenhrkgkgoukei03                                CHAR        (13)                                                      NOT NULL  ,  /* （連携用）円貨払込額の合計（円貨）０３ */
     zrnkihrkmp03                                       CHAR        (13)                                                      NOT NULL  ,  /* （連携用）既払込保険料０３ */
     zrnw03                                             CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金０３ */
     zrnwyenyendaka03                                   CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金（円貨）円高０３ */
     zrnwyenkijun03                                     CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金（円貨）中央値０３ */
     zrnwyenyenyasu03                                   CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金（円貨）円安０３ */
     zrnnenoutouym04                                    GRAPHIC     (8)                                                       NOT NULL  ,  /* （連携用）年単位応当年月０４ */
     zrnhrkkknmnryumukbn04                              CHAR        (1)                                                       NOT NULL  ,  /* （連携用）払込期間満了有無区分０４ */
     zrnzennouzndkyen04                                 CHAR        (13)                                                      NOT NULL  ,  /* （連携用）前納残高（円貨）０４ */
     zrnyenhrkgkgoukei04                                CHAR        (13)                                                      NOT NULL  ,  /* （連携用）円貨払込額の合計（円貨）０４ */
     zrnkihrkmp04                                       CHAR        (13)                                                      NOT NULL  ,  /* （連携用）既払込保険料０４ */
     zrnw04                                             CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金０４ */
     zrnwyenyendaka04                                   CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金（円貨）円高０４ */
     zrnwyenkijun04                                     CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金（円貨）中央値０４ */
     zrnwyenyenyasu04                                   CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金（円貨）円安０４ */
     zrnnenoutouym05                                    GRAPHIC     (8)                                                       NOT NULL  ,  /* （連携用）年単位応当年月０５ */
     zrnhrkkknmnryumukbn05                              CHAR        (1)                                                       NOT NULL  ,  /* （連携用）払込期間満了有無区分０５ */
     zrnzennouzndkyen05                                 CHAR        (13)                                                      NOT NULL  ,  /* （連携用）前納残高（円貨）０５ */
     zrnyenhrkgkgoukei05                                CHAR        (13)                                                      NOT NULL  ,  /* （連携用）円貨払込額の合計（円貨）０５ */
     zrnkihrkmp05                                       CHAR        (13)                                                      NOT NULL  ,  /* （連携用）既払込保険料０５ */
     zrnw05                                             CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金０５ */
     zrnwyenyendaka05                                   CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金（円貨）円高０５ */
     zrnwyenkijun05                                     CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金（円貨）中央値０５ */
     zrnwyenyenyasu05                                   CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金（円貨）円安０５ */
     zrnnenoutouym06                                    GRAPHIC     (8)                                                       NOT NULL  ,  /* （連携用）年単位応当年月０６ */
     zrnhrkkknmnryumukbn06                              CHAR        (1)                                                       NOT NULL  ,  /* （連携用）払込期間満了有無区分０６ */
     zrnzennouzndkyen06                                 CHAR        (13)                                                      NOT NULL  ,  /* （連携用）前納残高（円貨）０６ */
     zrnyenhrkgkgoukei06                                CHAR        (13)                                                      NOT NULL  ,  /* （連携用）円貨払込額の合計（円貨）０６ */
     zrnkihrkmp06                                       CHAR        (13)                                                      NOT NULL  ,  /* （連携用）既払込保険料０６ */
     zrnw06                                             CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金０６ */
     zrnwyenyendaka06                                   CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金（円貨）円高０６ */
     zrnwyenkijun06                                     CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金（円貨）中央値０６ */
     zrnwyenyenyasu06                                   CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金（円貨）円安０６ */
     zrnnenoutouym07                                    GRAPHIC     (8)                                                       NOT NULL  ,  /* （連携用）年単位応当年月０７ */
     zrnhrkkknmnryumukbn07                              CHAR        (1)                                                       NOT NULL  ,  /* （連携用）払込期間満了有無区分０７ */
     zrnzennouzndkyen07                                 CHAR        (13)                                                      NOT NULL  ,  /* （連携用）前納残高（円貨）０７ */
     zrnyenhrkgkgoukei07                                CHAR        (13)                                                      NOT NULL  ,  /* （連携用）円貨払込額の合計（円貨）０７ */
     zrnkihrkmp07                                       CHAR        (13)                                                      NOT NULL  ,  /* （連携用）既払込保険料０７ */
     zrnw07                                             CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金０７ */
     zrnwyenyendaka07                                   CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金（円貨）円高０７ */
     zrnwyenkijun07                                     CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金（円貨）中央値０７ */
     zrnwyenyenyasu07                                   CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金（円貨）円安０７ */
     zrnnenoutouym08                                    GRAPHIC     (8)                                                       NOT NULL  ,  /* （連携用）年単位応当年月０８ */
     zrnhrkkknmnryumukbn08                              CHAR        (1)                                                       NOT NULL  ,  /* （連携用）払込期間満了有無区分０８ */
     zrnzennouzndkyen08                                 CHAR        (13)                                                      NOT NULL  ,  /* （連携用）前納残高（円貨）０８ */
     zrnyenhrkgkgoukei08                                CHAR        (13)                                                      NOT NULL  ,  /* （連携用）円貨払込額の合計（円貨）０８ */
     zrnkihrkmp08                                       CHAR        (13)                                                      NOT NULL  ,  /* （連携用）既払込保険料０８ */
     zrnw08                                             CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金０８ */
     zrnwyenyendaka08                                   CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金（円貨）円高０８ */
     zrnwyenkijun08                                     CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金（円貨）中央値０８ */
     zrnwyenyenyasu08                                   CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金（円貨）円安０８ */
     zrnnenoutouym09                                    GRAPHIC     (8)                                                       NOT NULL  ,  /* （連携用）年単位応当年月０９ */
     zrnhrkkknmnryumukbn09                              CHAR        (1)                                                       NOT NULL  ,  /* （連携用）払込期間満了有無区分０９ */
     zrnzennouzndkyen09                                 CHAR        (13)                                                      NOT NULL  ,  /* （連携用）前納残高（円貨）０９ */
     zrnyenhrkgkgoukei09                                CHAR        (13)                                                      NOT NULL  ,  /* （連携用）円貨払込額の合計（円貨）０９ */
     zrnkihrkmp09                                       CHAR        (13)                                                      NOT NULL  ,  /* （連携用）既払込保険料０９ */
     zrnw09                                             CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金０９ */
     zrnwyenyendaka09                                   CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金（円貨）円高０９ */
     zrnwyenkijun09                                     CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金（円貨）中央値０９ */
     zrnwyenyenyasu09                                   CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金（円貨）円安０９ */
     zrnnenoutouym10                                    GRAPHIC     (8)                                                       NOT NULL  ,  /* （連携用）年単位応当年月１０ */
     zrnhrkkknmnryumukbn10                              CHAR        (1)                                                       NOT NULL  ,  /* （連携用）払込期間満了有無区分１０ */
     zrnzennouzndkyen10                                 CHAR        (13)                                                      NOT NULL  ,  /* （連携用）前納残高（円貨）１０ */
     zrnyenhrkgkgoukei10                                CHAR        (13)                                                      NOT NULL  ,  /* （連携用）円貨払込額の合計（円貨）１０ */
     zrnkihrkmp10                                       CHAR        (13)                                                      NOT NULL  ,  /* （連携用）既払込保険料１０ */
     zrnw10                                             CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金１０ */
     zrnwyenyendaka10                                   CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金（円貨）円高１０ */
     zrnwyenkijun10                                     CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金（円貨）中央値１０ */
     zrnwyenyenyasu10                                   CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金（円貨）円安１０ */
     zrnnenoutouym11                                    GRAPHIC     (8)                                                       NOT NULL  ,  /* （連携用）年単位応当年月１１ */
     zrnhrkkknmnryumukbn11                              CHAR        (1)                                                       NOT NULL  ,  /* （連携用）払込期間満了有無区分１１ */
     zrnzennouzndkyen11                                 CHAR        (13)                                                      NOT NULL  ,  /* （連携用）前納残高（円貨）１１ */
     zrnyenhrkgkgoukei11                                CHAR        (13)                                                      NOT NULL  ,  /* （連携用）円貨払込額の合計（円貨）１１ */
     zrnkihrkmp11                                       CHAR        (13)                                                      NOT NULL  ,  /* （連携用）既払込保険料１１ */
     zrnw11                                             CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金１１ */
     zrnwyenyendaka11                                   CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金（円貨）円高１１ */
     zrnwyenkijun11                                     CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金（円貨）中央値１１ */
     zrnwyenyenyasu11                                   CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金（円貨）円安１１ */
     zrnnenoutouym12                                    GRAPHIC     (8)                                                       NOT NULL  ,  /* （連携用）年単位応当年月１２ */
     zrnhrkkknmnryumukbn12                              CHAR        (1)                                                       NOT NULL  ,  /* （連携用）払込期間満了有無区分１２ */
     zrnzennouzndkyen12                                 CHAR        (13)                                                      NOT NULL  ,  /* （連携用）前納残高（円貨）１２ */
     zrnyenhrkgkgoukei12                                CHAR        (13)                                                      NOT NULL  ,  /* （連携用）円貨払込額の合計（円貨）１２ */
     zrnkihrkmp12                                       CHAR        (13)                                                      NOT NULL  ,  /* （連携用）既払込保険料１２ */
     zrnw12                                             CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金１２ */
     zrnwyenyendaka12                                   CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金（円貨）円高１２ */
     zrnwyenkijun12                                     CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金（円貨）中央値１２ */
     zrnwyenyenyasu12                                   CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金（円貨）円安１２ */
     zrnnenoutouym13                                    GRAPHIC     (8)                                                       NOT NULL  ,  /* （連携用）年単位応当年月１３ */
     zrnhrkkknmnryumukbn13                              CHAR        (1)                                                       NOT NULL  ,  /* （連携用）払込期間満了有無区分１３ */
     zrnzennouzndkyen13                                 CHAR        (13)                                                      NOT NULL  ,  /* （連携用）前納残高（円貨）１３ */
     zrnyenhrkgkgoukei13                                CHAR        (13)                                                      NOT NULL  ,  /* （連携用）円貨払込額の合計（円貨）１３ */
     zrnkihrkmp13                                       CHAR        (13)                                                      NOT NULL  ,  /* （連携用）既払込保険料１３ */
     zrnw13                                             CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金１３ */
     zrnwyenyendaka13                                   CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金（円貨）円高１３ */
     zrnwyenkijun13                                     CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金（円貨）中央値１３ */
     zrnwyenyenyasu13                                   CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金（円貨）円安１３ */
     zrnnenoutouym14                                    GRAPHIC     (8)                                                       NOT NULL  ,  /* （連携用）年単位応当年月１４ */
     zrnhrkkknmnryumukbn14                              CHAR        (1)                                                       NOT NULL  ,  /* （連携用）払込期間満了有無区分１４ */
     zrnzennouzndkyen14                                 CHAR        (13)                                                      NOT NULL  ,  /* （連携用）前納残高（円貨）１４ */
     zrnyenhrkgkgoukei14                                CHAR        (13)                                                      NOT NULL  ,  /* （連携用）円貨払込額の合計（円貨）１４ */
     zrnkihrkmp14                                       CHAR        (13)                                                      NOT NULL  ,  /* （連携用）既払込保険料１４ */
     zrnw14                                             CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金１４ */
     zrnwyenyendaka14                                   CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金（円貨）円高１４ */
     zrnwyenkijun14                                     CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金（円貨）中央値１４ */
     zrnwyenyenyasu14                                   CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金（円貨）円安１４ */
     zrnnenoutouym15                                    GRAPHIC     (8)                                                       NOT NULL  ,  /* （連携用）年単位応当年月１５ */
     zrnhrkkknmnryumukbn15                              CHAR        (1)                                                       NOT NULL  ,  /* （連携用）払込期間満了有無区分１５ */
     zrnzennouzndkyen15                                 CHAR        (13)                                                      NOT NULL  ,  /* （連携用）前納残高（円貨）１５ */
     zrnyenhrkgkgoukei15                                CHAR        (13)                                                      NOT NULL  ,  /* （連携用）円貨払込額の合計（円貨）１５ */
     zrnkihrkmp15                                       CHAR        (13)                                                      NOT NULL  ,  /* （連携用）既払込保険料１５ */
     zrnw15                                             CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金１５ */
     zrnwyenyendaka15                                   CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金（円貨）円高１５ */
     zrnwyenkijun15                                     CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金（円貨）中央値１５ */
     zrnwyenyenyasu15                                   CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金（円貨）円安１５ */
     zrnnenoutouym16                                    GRAPHIC     (8)                                                       NOT NULL  ,  /* （連携用）年単位応当年月１６ */
     zrnhrkkknmnryumukbn16                              CHAR        (1)                                                       NOT NULL  ,  /* （連携用）払込期間満了有無区分１６ */
     zrnzennouzndkyen16                                 CHAR        (13)                                                      NOT NULL  ,  /* （連携用）前納残高（円貨）１６ */
     zrnyenhrkgkgoukei16                                CHAR        (13)                                                      NOT NULL  ,  /* （連携用）円貨払込額の合計（円貨）１６ */
     zrnkihrkmp16                                       CHAR        (13)                                                      NOT NULL  ,  /* （連携用）既払込保険料１６ */
     zrnw16                                             CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金１６ */
     zrnwyenyendaka16                                   CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金（円貨）円高１６ */
     zrnwyenkijun16                                     CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金（円貨）中央値１６ */
     zrnwyenyenyasu16                                   CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金（円貨）円安１６ */
     zrnnenoutouym17                                    GRAPHIC     (8)                                                       NOT NULL  ,  /* （連携用）年単位応当年月１７ */
     zrnhrkkknmnryumukbn17                              CHAR        (1)                                                       NOT NULL  ,  /* （連携用）払込期間満了有無区分１７ */
     zrnzennouzndkyen17                                 CHAR        (13)                                                      NOT NULL  ,  /* （連携用）前納残高（円貨）１７ */
     zrnyenhrkgkgoukei17                                CHAR        (13)                                                      NOT NULL  ,  /* （連携用）円貨払込額の合計（円貨）１７ */
     zrnkihrkmp17                                       CHAR        (13)                                                      NOT NULL  ,  /* （連携用）既払込保険料１７ */
     zrnw17                                             CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金１７ */
     zrnwyenyendaka17                                   CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金（円貨）円高１７ */
     zrnwyenkijun17                                     CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金（円貨）中央値１７ */
     zrnwyenyenyasu17                                   CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金（円貨）円安１７ */
     zrnnenoutouym18                                    GRAPHIC     (8)                                                       NOT NULL  ,  /* （連携用）年単位応当年月１８ */
     zrnhrkkknmnryumukbn18                              CHAR        (1)                                                       NOT NULL  ,  /* （連携用）払込期間満了有無区分１８ */
     zrnzennouzndkyen18                                 CHAR        (13)                                                      NOT NULL  ,  /* （連携用）前納残高（円貨）１８ */
     zrnyenhrkgkgoukei18                                CHAR        (13)                                                      NOT NULL  ,  /* （連携用）円貨払込額の合計（円貨）１８ */
     zrnkihrkmp18                                       CHAR        (13)                                                      NOT NULL  ,  /* （連携用）既払込保険料１８ */
     zrnw18                                             CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金１８ */
     zrnwyenyendaka18                                   CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金（円貨）円高１８ */
     zrnwyenkijun18                                     CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金（円貨）中央値１８ */
     zrnwyenyenyasu18                                   CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金（円貨）円安１８ */
     zrnnenoutouym19                                    GRAPHIC     (8)                                                       NOT NULL  ,  /* （連携用）年単位応当年月１９ */
     zrnhrkkknmnryumukbn19                              CHAR        (1)                                                       NOT NULL  ,  /* （連携用）払込期間満了有無区分１９ */
     zrnzennouzndkyen19                                 CHAR        (13)                                                      NOT NULL  ,  /* （連携用）前納残高（円貨）１９ */
     zrnyenhrkgkgoukei19                                CHAR        (13)                                                      NOT NULL  ,  /* （連携用）円貨払込額の合計（円貨）１９ */
     zrnkihrkmp19                                       CHAR        (13)                                                      NOT NULL  ,  /* （連携用）既払込保険料１９ */
     zrnw19                                             CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金１９ */
     zrnwyenyendaka19                                   CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金（円貨）円高１９ */
     zrnwyenkijun19                                     CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金（円貨）中央値１９ */
     zrnwyenyenyasu19                                   CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金（円貨）円安１９ */
     zrnnenoutouym20                                    GRAPHIC     (8)                                                       NOT NULL  ,  /* （連携用）年単位応当年月２０ */
     zrnhrkkknmnryumukbn20                              CHAR        (1)                                                       NOT NULL  ,  /* （連携用）払込期間満了有無区分２０ */
     zrnzennouzndkyen20                                 CHAR        (13)                                                      NOT NULL  ,  /* （連携用）前納残高（円貨）２０ */
     zrnyenhrkgkgoukei20                                CHAR        (13)                                                      NOT NULL  ,  /* （連携用）円貨払込額の合計（円貨）２０ */
     zrnkihrkmp20                                       CHAR        (13)                                                      NOT NULL  ,  /* （連携用）既払込保険料２０ */
     zrnw20                                             CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金２０ */
     zrnwyenyendaka20                                   CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金（円貨）円高２０ */
     zrnwyenkijun20                                     CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金（円貨）中央値２０ */
     zrnwyenyenyasu20                                   CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金（円貨）円安２０ */
     zrnnenoutouym21                                    GRAPHIC     (8)                                                       NOT NULL  ,  /* （連携用）年単位応当年月２１ */
     zrnhrkkknmnryumukbn21                              CHAR        (1)                                                       NOT NULL  ,  /* （連携用）払込期間満了有無区分２１ */
     zrnzennouzndkyen21                                 CHAR        (13)                                                      NOT NULL  ,  /* （連携用）前納残高（円貨）２１ */
     zrnyenhrkgkgoukei21                                CHAR        (13)                                                      NOT NULL  ,  /* （連携用）円貨払込額の合計（円貨）２１ */
     zrnkihrkmp21                                       CHAR        (13)                                                      NOT NULL  ,  /* （連携用）既払込保険料２１ */
     zrnw21                                             CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金２１ */
     zrnwyenyendaka21                                   CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金（円貨）円高２１ */
     zrnwyenkijun21                                     CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金（円貨）中央値２１ */
     zrnwyenyenyasu21                                   CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金（円貨）円安２１ */
     zrnnenoutouym22                                    GRAPHIC     (8)                                                       NOT NULL  ,  /* （連携用）年単位応当年月２２ */
     zrnhrkkknmnryumukbn22                              CHAR        (1)                                                       NOT NULL  ,  /* （連携用）払込期間満了有無区分２２ */
     zrnzennouzndkyen22                                 CHAR        (13)                                                      NOT NULL  ,  /* （連携用）前納残高（円貨）２２ */
     zrnyenhrkgkgoukei22                                CHAR        (13)                                                      NOT NULL  ,  /* （連携用）円貨払込額の合計（円貨）２２ */
     zrnkihrkmp22                                       CHAR        (13)                                                      NOT NULL  ,  /* （連携用）既払込保険料２２ */
     zrnw22                                             CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金２２ */
     zrnwyenyendaka22                                   CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金（円貨）円高２２ */
     zrnwyenkijun22                                     CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金（円貨）中央値２２ */
     zrnwyenyenyasu22                                   CHAR        (13)                                                      NOT NULL  ,  /* （連携用）解約返戻金（円貨）円安２２ */
     zrnyobiv300                                        CHAR        (300)                                                     NOT NULL  ,  /* （連携用）予備項目Ｖ３００ */
     zrnyobiv12                                         CHAR        (12)                                                      NOT NULL     /* （連携用）予備項目Ｖ１２ */
)
;

ALTER TABLE ZT_SaihakkouSyoukenSuii2Rn_Z ADD CONSTRAINT PK_SaihakkouSyoukenSuii2Rn PRIMARY KEY (
     zrnsyono                                                 , /* （連携用）証券番号 */
     zrntyouhyouymd                                           , /* （連携用）帳票作成日 */
     zrnsuiihyouptn                                             /* （連携用）推移表パターン */
) ;
