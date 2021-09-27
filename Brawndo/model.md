main.Autoroute.main.Autoroute à 5 niveaux
    => 2 à 6 accès
    => Décalage de n degrés
    => vitesse différentes
    => circon !=
    => dans le même sens
    => in et out au même niveau

Ne ralenti jamais
Toujours vers le centre
Si 1 tours on bouge
Si accident => main.Exception

Tous vehicules
v vehicule !=
accident + panne


main.Idioroute
    => Instancier 5 autoroutes
    => Instancier n vehicule
    => autorouteController
        => avancer
            => vehicule x => avance de n mètres
        => haveAccident => check si accident
        => needMoveLevel => out next exit (position)
        => cancelAccident => check si potentiel 
    => moveLevel => out check position => in
        