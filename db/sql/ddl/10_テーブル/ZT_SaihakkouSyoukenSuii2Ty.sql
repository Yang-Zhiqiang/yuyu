CREATE TABLE ZT_SaihakkouSyoukenSuii2Ty (
     ztysyono                                           VARCHAR     (11)                                                      NOT NULL  ,  /* （中継用）証券番号 */
     ztytyouhyouymd                                     VARCHAR     (8)                                                       NOT NULL  ,  /* （中継用）帳票作成日 */
     ztysuiihyouptn                                     VARCHAR     (2)                                                       NOT NULL  ,  /* （中継用）推移表パターン */
     ztysuiihyousykbn                                   VARCHAR     (2)                                                                 ,  /* （中継用）推移表種別区分 */
     ztysuiihyousyono                                   VARCHAR     (11)                                                                ,  /* （中継用）推移表証券番号 */
     ztyytirrtcalckijyunrrt                             VARCHAR     (5)                                                                 ,  /* （中継用）予定利率計算基準利率 */
     ztywkwsrateyendaka                                 VARCHAR     (5)                                                                 ,  /* （中継用）解約返戻金為替レート（円高） */
     ztywkwsrateyenkijyun                               VARCHAR     (5)                                                                 ,  /* （中継用）解約返戻金為替レート（中央値） */
     ztywkwsrateyenyasu                                 VARCHAR     (5)                                                                 ,  /* （中継用）解約返戻金為替レート（円安） */
     ztykyktuukatype                                    VARCHAR     (3)                                                                 ,  /* （中継用）契約通貨タイプ */
     ztynenoutouym01                                    VARCHAR     (8)                                                                 ,  /* （中継用）年単位応当年月０１ */
     ztyhrkkknmnryumukbn01                              VARCHAR     (1)                                                                 ,  /* （中継用）払込期間満了有無区分０１ */
     ztyzennouzndkyen01                                 VARCHAR     (13)                                                                ,  /* （中継用）前納残高（円貨）０１ */
     ztyyenhrkgkgoukei01                                VARCHAR     (13)                                                                ,  /* （中継用）円貨払込額の合計（円貨）０１ */
     ztykihrkmp01                                       VARCHAR     (13)                                                                ,  /* （中継用）既払込保険料０１ */
     ztyw01                                             VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金０１ */
     ztywyenyendaka01                                   VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金（円貨）円高０１ */
     ztywyenkijun01                                     VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金（円貨）中央値０１ */
     ztywyenyenyasu01                                   VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金（円貨）円安０１ */
     ztynenoutouym02                                    VARCHAR     (8)                                                                 ,  /* （中継用）年単位応当年月０２ */
     ztyhrkkknmnryumukbn02                              VARCHAR     (1)                                                                 ,  /* （中継用）払込期間満了有無区分０２ */
     ztyzennouzndkyen02                                 VARCHAR     (13)                                                                ,  /* （中継用）前納残高（円貨）０２ */
     ztyyenhrkgkgoukei02                                VARCHAR     (13)                                                                ,  /* （中継用）円貨払込額の合計（円貨）０２ */
     ztykihrkmp02                                       VARCHAR     (13)                                                                ,  /* （中継用）既払込保険料０２ */
     ztyw02                                             VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金０２ */
     ztywyenyendaka02                                   VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金（円貨）円高０２ */
     ztywyenkijun02                                     VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金（円貨）中央値０２ */
     ztywyenyenyasu02                                   VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金（円貨）円安０２ */
     ztynenoutouym03                                    VARCHAR     (8)                                                                 ,  /* （中継用）年単位応当年月０３ */
     ztyhrkkknmnryumukbn03                              VARCHAR     (1)                                                                 ,  /* （中継用）払込期間満了有無区分０３ */
     ztyzennouzndkyen03                                 VARCHAR     (13)                                                                ,  /* （中継用）前納残高（円貨）０３ */
     ztyyenhrkgkgoukei03                                VARCHAR     (13)                                                                ,  /* （中継用）円貨払込額の合計（円貨）０３ */
     ztykihrkmp03                                       VARCHAR     (13)                                                                ,  /* （中継用）既払込保険料０３ */
     ztyw03                                             VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金０３ */
     ztywyenyendaka03                                   VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金（円貨）円高０３ */
     ztywyenkijun03                                     VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金（円貨）中央値０３ */
     ztywyenyenyasu03                                   VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金（円貨）円安０３ */
     ztynenoutouym04                                    VARCHAR     (8)                                                                 ,  /* （中継用）年単位応当年月０４ */
     ztyhrkkknmnryumukbn04                              VARCHAR     (1)                                                                 ,  /* （中継用）払込期間満了有無区分０４ */
     ztyzennouzndkyen04                                 VARCHAR     (13)                                                                ,  /* （中継用）前納残高（円貨）０４ */
     ztyyenhrkgkgoukei04                                VARCHAR     (13)                                                                ,  /* （中継用）円貨払込額の合計（円貨）０４ */
     ztykihrkmp04                                       VARCHAR     (13)                                                                ,  /* （中継用）既払込保険料０４ */
     ztyw04                                             VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金０４ */
     ztywyenyendaka04                                   VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金（円貨）円高０４ */
     ztywyenkijun04                                     VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金（円貨）中央値０４ */
     ztywyenyenyasu04                                   VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金（円貨）円安０４ */
     ztynenoutouym05                                    VARCHAR     (8)                                                                 ,  /* （中継用）年単位応当年月０５ */
     ztyhrkkknmnryumukbn05                              VARCHAR     (1)                                                                 ,  /* （中継用）払込期間満了有無区分０５ */
     ztyzennouzndkyen05                                 VARCHAR     (13)                                                                ,  /* （中継用）前納残高（円貨）０５ */
     ztyyenhrkgkgoukei05                                VARCHAR     (13)                                                                ,  /* （中継用）円貨払込額の合計（円貨）０５ */
     ztykihrkmp05                                       VARCHAR     (13)                                                                ,  /* （中継用）既払込保険料０５ */
     ztyw05                                             VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金０５ */
     ztywyenyendaka05                                   VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金（円貨）円高０５ */
     ztywyenkijun05                                     VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金（円貨）中央値０５ */
     ztywyenyenyasu05                                   VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金（円貨）円安０５ */
     ztynenoutouym06                                    VARCHAR     (8)                                                                 ,  /* （中継用）年単位応当年月０６ */
     ztyhrkkknmnryumukbn06                              VARCHAR     (1)                                                                 ,  /* （中継用）払込期間満了有無区分０６ */
     ztyzennouzndkyen06                                 VARCHAR     (13)                                                                ,  /* （中継用）前納残高（円貨）０６ */
     ztyyenhrkgkgoukei06                                VARCHAR     (13)                                                                ,  /* （中継用）円貨払込額の合計（円貨）０６ */
     ztykihrkmp06                                       VARCHAR     (13)                                                                ,  /* （中継用）既払込保険料０６ */
     ztyw06                                             VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金０６ */
     ztywyenyendaka06                                   VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金（円貨）円高０６ */
     ztywyenkijun06                                     VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金（円貨）中央値０６ */
     ztywyenyenyasu06                                   VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金（円貨）円安０６ */
     ztynenoutouym07                                    VARCHAR     (8)                                                                 ,  /* （中継用）年単位応当年月０７ */
     ztyhrkkknmnryumukbn07                              VARCHAR     (1)                                                                 ,  /* （中継用）払込期間満了有無区分０７ */
     ztyzennouzndkyen07                                 VARCHAR     (13)                                                                ,  /* （中継用）前納残高（円貨）０７ */
     ztyyenhrkgkgoukei07                                VARCHAR     (13)                                                                ,  /* （中継用）円貨払込額の合計（円貨）０７ */
     ztykihrkmp07                                       VARCHAR     (13)                                                                ,  /* （中継用）既払込保険料０７ */
     ztyw07                                             VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金０７ */
     ztywyenyendaka07                                   VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金（円貨）円高０７ */
     ztywyenkijun07                                     VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金（円貨）中央値０７ */
     ztywyenyenyasu07                                   VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金（円貨）円安０７ */
     ztynenoutouym08                                    VARCHAR     (8)                                                                 ,  /* （中継用）年単位応当年月０８ */
     ztyhrkkknmnryumukbn08                              VARCHAR     (1)                                                                 ,  /* （中継用）払込期間満了有無区分０８ */
     ztyzennouzndkyen08                                 VARCHAR     (13)                                                                ,  /* （中継用）前納残高（円貨）０８ */
     ztyyenhrkgkgoukei08                                VARCHAR     (13)                                                                ,  /* （中継用）円貨払込額の合計（円貨）０８ */
     ztykihrkmp08                                       VARCHAR     (13)                                                                ,  /* （中継用）既払込保険料０８ */
     ztyw08                                             VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金０８ */
     ztywyenyendaka08                                   VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金（円貨）円高０８ */
     ztywyenkijun08                                     VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金（円貨）中央値０８ */
     ztywyenyenyasu08                                   VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金（円貨）円安０８ */
     ztynenoutouym09                                    VARCHAR     (8)                                                                 ,  /* （中継用）年単位応当年月０９ */
     ztyhrkkknmnryumukbn09                              VARCHAR     (1)                                                                 ,  /* （中継用）払込期間満了有無区分０９ */
     ztyzennouzndkyen09                                 VARCHAR     (13)                                                                ,  /* （中継用）前納残高（円貨）０９ */
     ztyyenhrkgkgoukei09                                VARCHAR     (13)                                                                ,  /* （中継用）円貨払込額の合計（円貨）０９ */
     ztykihrkmp09                                       VARCHAR     (13)                                                                ,  /* （中継用）既払込保険料０９ */
     ztyw09                                             VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金０９ */
     ztywyenyendaka09                                   VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金（円貨）円高０９ */
     ztywyenkijun09                                     VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金（円貨）中央値０９ */
     ztywyenyenyasu09                                   VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金（円貨）円安０９ */
     ztynenoutouym10                                    VARCHAR     (8)                                                                 ,  /* （中継用）年単位応当年月１０ */
     ztyhrkkknmnryumukbn10                              VARCHAR     (1)                                                                 ,  /* （中継用）払込期間満了有無区分１０ */
     ztyzennouzndkyen10                                 VARCHAR     (13)                                                                ,  /* （中継用）前納残高（円貨）１０ */
     ztyyenhrkgkgoukei10                                VARCHAR     (13)                                                                ,  /* （中継用）円貨払込額の合計（円貨）１０ */
     ztykihrkmp10                                       VARCHAR     (13)                                                                ,  /* （中継用）既払込保険料１０ */
     ztyw10                                             VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金１０ */
     ztywyenyendaka10                                   VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金（円貨）円高１０ */
     ztywyenkijun10                                     VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金（円貨）中央値１０ */
     ztywyenyenyasu10                                   VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金（円貨）円安１０ */
     ztynenoutouym11                                    VARCHAR     (8)                                                                 ,  /* （中継用）年単位応当年月１１ */
     ztyhrkkknmnryumukbn11                              VARCHAR     (1)                                                                 ,  /* （中継用）払込期間満了有無区分１１ */
     ztyzennouzndkyen11                                 VARCHAR     (13)                                                                ,  /* （中継用）前納残高（円貨）１１ */
     ztyyenhrkgkgoukei11                                VARCHAR     (13)                                                                ,  /* （中継用）円貨払込額の合計（円貨）１１ */
     ztykihrkmp11                                       VARCHAR     (13)                                                                ,  /* （中継用）既払込保険料１１ */
     ztyw11                                             VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金１１ */
     ztywyenyendaka11                                   VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金（円貨）円高１１ */
     ztywyenkijun11                                     VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金（円貨）中央値１１ */
     ztywyenyenyasu11                                   VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金（円貨）円安１１ */
     ztynenoutouym12                                    VARCHAR     (8)                                                                 ,  /* （中継用）年単位応当年月１２ */
     ztyhrkkknmnryumukbn12                              VARCHAR     (1)                                                                 ,  /* （中継用）払込期間満了有無区分１２ */
     ztyzennouzndkyen12                                 VARCHAR     (13)                                                                ,  /* （中継用）前納残高（円貨）１２ */
     ztyyenhrkgkgoukei12                                VARCHAR     (13)                                                                ,  /* （中継用）円貨払込額の合計（円貨）１２ */
     ztykihrkmp12                                       VARCHAR     (13)                                                                ,  /* （中継用）既払込保険料１２ */
     ztyw12                                             VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金１２ */
     ztywyenyendaka12                                   VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金（円貨）円高１２ */
     ztywyenkijun12                                     VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金（円貨）中央値１２ */
     ztywyenyenyasu12                                   VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金（円貨）円安１２ */
     ztynenoutouym13                                    VARCHAR     (8)                                                                 ,  /* （中継用）年単位応当年月１３ */
     ztyhrkkknmnryumukbn13                              VARCHAR     (1)                                                                 ,  /* （中継用）払込期間満了有無区分１３ */
     ztyzennouzndkyen13                                 VARCHAR     (13)                                                                ,  /* （中継用）前納残高（円貨）１３ */
     ztyyenhrkgkgoukei13                                VARCHAR     (13)                                                                ,  /* （中継用）円貨払込額の合計（円貨）１３ */
     ztykihrkmp13                                       VARCHAR     (13)                                                                ,  /* （中継用）既払込保険料１３ */
     ztyw13                                             VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金１３ */
     ztywyenyendaka13                                   VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金（円貨）円高１３ */
     ztywyenkijun13                                     VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金（円貨）中央値１３ */
     ztywyenyenyasu13                                   VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金（円貨）円安１３ */
     ztynenoutouym14                                    VARCHAR     (8)                                                                 ,  /* （中継用）年単位応当年月１４ */
     ztyhrkkknmnryumukbn14                              VARCHAR     (1)                                                                 ,  /* （中継用）払込期間満了有無区分１４ */
     ztyzennouzndkyen14                                 VARCHAR     (13)                                                                ,  /* （中継用）前納残高（円貨）１４ */
     ztyyenhrkgkgoukei14                                VARCHAR     (13)                                                                ,  /* （中継用）円貨払込額の合計（円貨）１４ */
     ztykihrkmp14                                       VARCHAR     (13)                                                                ,  /* （中継用）既払込保険料１４ */
     ztyw14                                             VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金１４ */
     ztywyenyendaka14                                   VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金（円貨）円高１４ */
     ztywyenkijun14                                     VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金（円貨）中央値１４ */
     ztywyenyenyasu14                                   VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金（円貨）円安１４ */
     ztynenoutouym15                                    VARCHAR     (8)                                                                 ,  /* （中継用）年単位応当年月１５ */
     ztyhrkkknmnryumukbn15                              VARCHAR     (1)                                                                 ,  /* （中継用）払込期間満了有無区分１５ */
     ztyzennouzndkyen15                                 VARCHAR     (13)                                                                ,  /* （中継用）前納残高（円貨）１５ */
     ztyyenhrkgkgoukei15                                VARCHAR     (13)                                                                ,  /* （中継用）円貨払込額の合計（円貨）１５ */
     ztykihrkmp15                                       VARCHAR     (13)                                                                ,  /* （中継用）既払込保険料１５ */
     ztyw15                                             VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金１５ */
     ztywyenyendaka15                                   VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金（円貨）円高１５ */
     ztywyenkijun15                                     VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金（円貨）中央値１５ */
     ztywyenyenyasu15                                   VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金（円貨）円安１５ */
     ztynenoutouym16                                    VARCHAR     (8)                                                                 ,  /* （中継用）年単位応当年月１６ */
     ztyhrkkknmnryumukbn16                              VARCHAR     (1)                                                                 ,  /* （中継用）払込期間満了有無区分１６ */
     ztyzennouzndkyen16                                 VARCHAR     (13)                                                                ,  /* （中継用）前納残高（円貨）１６ */
     ztyyenhrkgkgoukei16                                VARCHAR     (13)                                                                ,  /* （中継用）円貨払込額の合計（円貨）１６ */
     ztykihrkmp16                                       VARCHAR     (13)                                                                ,  /* （中継用）既払込保険料１６ */
     ztyw16                                             VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金１６ */
     ztywyenyendaka16                                   VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金（円貨）円高１６ */
     ztywyenkijun16                                     VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金（円貨）中央値１６ */
     ztywyenyenyasu16                                   VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金（円貨）円安１６ */
     ztynenoutouym17                                    VARCHAR     (8)                                                                 ,  /* （中継用）年単位応当年月１７ */
     ztyhrkkknmnryumukbn17                              VARCHAR     (1)                                                                 ,  /* （中継用）払込期間満了有無区分１７ */
     ztyzennouzndkyen17                                 VARCHAR     (13)                                                                ,  /* （中継用）前納残高（円貨）１７ */
     ztyyenhrkgkgoukei17                                VARCHAR     (13)                                                                ,  /* （中継用）円貨払込額の合計（円貨）１７ */
     ztykihrkmp17                                       VARCHAR     (13)                                                                ,  /* （中継用）既払込保険料１７ */
     ztyw17                                             VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金１７ */
     ztywyenyendaka17                                   VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金（円貨）円高１７ */
     ztywyenkijun17                                     VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金（円貨）中央値１７ */
     ztywyenyenyasu17                                   VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金（円貨）円安１７ */
     ztynenoutouym18                                    VARCHAR     (8)                                                                 ,  /* （中継用）年単位応当年月１８ */
     ztyhrkkknmnryumukbn18                              VARCHAR     (1)                                                                 ,  /* （中継用）払込期間満了有無区分１８ */
     ztyzennouzndkyen18                                 VARCHAR     (13)                                                                ,  /* （中継用）前納残高（円貨）１８ */
     ztyyenhrkgkgoukei18                                VARCHAR     (13)                                                                ,  /* （中継用）円貨払込額の合計（円貨）１８ */
     ztykihrkmp18                                       VARCHAR     (13)                                                                ,  /* （中継用）既払込保険料１８ */
     ztyw18                                             VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金１８ */
     ztywyenyendaka18                                   VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金（円貨）円高１８ */
     ztywyenkijun18                                     VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金（円貨）中央値１８ */
     ztywyenyenyasu18                                   VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金（円貨）円安１８ */
     ztynenoutouym19                                    VARCHAR     (8)                                                                 ,  /* （中継用）年単位応当年月１９ */
     ztyhrkkknmnryumukbn19                              VARCHAR     (1)                                                                 ,  /* （中継用）払込期間満了有無区分１９ */
     ztyzennouzndkyen19                                 VARCHAR     (13)                                                                ,  /* （中継用）前納残高（円貨）１９ */
     ztyyenhrkgkgoukei19                                VARCHAR     (13)                                                                ,  /* （中継用）円貨払込額の合計（円貨）１９ */
     ztykihrkmp19                                       VARCHAR     (13)                                                                ,  /* （中継用）既払込保険料１９ */
     ztyw19                                             VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金１９ */
     ztywyenyendaka19                                   VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金（円貨）円高１９ */
     ztywyenkijun19                                     VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金（円貨）中央値１９ */
     ztywyenyenyasu19                                   VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金（円貨）円安１９ */
     ztynenoutouym20                                    VARCHAR     (8)                                                                 ,  /* （中継用）年単位応当年月２０ */
     ztyhrkkknmnryumukbn20                              VARCHAR     (1)                                                                 ,  /* （中継用）払込期間満了有無区分２０ */
     ztyzennouzndkyen20                                 VARCHAR     (13)                                                                ,  /* （中継用）前納残高（円貨）２０ */
     ztyyenhrkgkgoukei20                                VARCHAR     (13)                                                                ,  /* （中継用）円貨払込額の合計（円貨）２０ */
     ztykihrkmp20                                       VARCHAR     (13)                                                                ,  /* （中継用）既払込保険料２０ */
     ztyw20                                             VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金２０ */
     ztywyenyendaka20                                   VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金（円貨）円高２０ */
     ztywyenkijun20                                     VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金（円貨）中央値２０ */
     ztywyenyenyasu20                                   VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金（円貨）円安２０ */
     ztynenoutouym21                                    VARCHAR     (8)                                                                 ,  /* （中継用）年単位応当年月２１ */
     ztyhrkkknmnryumukbn21                              VARCHAR     (1)                                                                 ,  /* （中継用）払込期間満了有無区分２１ */
     ztyzennouzndkyen21                                 VARCHAR     (13)                                                                ,  /* （中継用）前納残高（円貨）２１ */
     ztyyenhrkgkgoukei21                                VARCHAR     (13)                                                                ,  /* （中継用）円貨払込額の合計（円貨）２１ */
     ztykihrkmp21                                       VARCHAR     (13)                                                                ,  /* （中継用）既払込保険料２１ */
     ztyw21                                             VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金２１ */
     ztywyenyendaka21                                   VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金（円貨）円高２１ */
     ztywyenkijun21                                     VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金（円貨）中央値２１ */
     ztywyenyenyasu21                                   VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金（円貨）円安２１ */
     ztynenoutouym22                                    VARCHAR     (8)                                                                 ,  /* （中継用）年単位応当年月２２ */
     ztyhrkkknmnryumukbn22                              VARCHAR     (1)                                                                 ,  /* （中継用）払込期間満了有無区分２２ */
     ztyzennouzndkyen22                                 VARCHAR     (13)                                                                ,  /* （中継用）前納残高（円貨）２２ */
     ztyyenhrkgkgoukei22                                VARCHAR     (13)                                                                ,  /* （中継用）円貨払込額の合計（円貨）２２ */
     ztykihrkmp22                                       VARCHAR     (13)                                                                ,  /* （中継用）既払込保険料２２ */
     ztyw22                                             VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金２２ */
     ztywyenyendaka22                                   VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金（円貨）円高２２ */
     ztywyenkijun22                                     VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金（円貨）中央値２２ */
     ztywyenyenyasu22                                   VARCHAR     (13)                                                                ,  /* （中継用）解約返戻金（円貨）円安２２ */
     ztyyobiv300                                        VARCHAR     (300)                                                               ,  /* （中継用）予備項目Ｖ３００ */
     ztyyobiv12                                         VARCHAR     (12)                                                                ,  /* （中継用）予備項目Ｖ１２ */
     kousinsyaId                                        VARCHAR     (30)                                                                ,  /* 更新者ＩＤ */
     kousinTime                                         VARCHAR     (17)                                                                ,  /* 更新時間 */
     kousinKinou                                        VARCHAR     (50)                                                                ,  /* 更新機能 */
     version                                            BIGINT      NOT NULL  DEFAULT 0                                                    /* バージョン */
)
;

ALTER TABLE ZT_SaihakkouSyoukenSuii2Ty ADD CONSTRAINT PK_SaihakkouSyoukenSuii2Ty PRIMARY KEY (
     ztysyono                                                 , /* （中継用）証券番号 */
     ztytyouhyouymd                                           , /* （中継用）帳票作成日 */
     ztysuiihyouptn                                             /* （中継用）推移表パターン */
) ;
