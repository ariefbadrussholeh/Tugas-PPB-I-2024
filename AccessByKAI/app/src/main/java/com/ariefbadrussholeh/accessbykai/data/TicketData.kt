package com.ariefbadrussholeh.accessbykai.data

data class Ticket(
    val argo: String,
    val startLeaving: String,
    val arrive: String,
    val estimatedTime: String,
    val price: String,
    val argoClass: String,
    val ticketRemaining: Int
)

val ticketList = listOf(
    Ticket(
        argo = "Argo Bromo Anggrek",
        startLeaving = "06:00",
        arrive = "08:30",
        estimatedTime = "2 jam 30 menit",
        price = "Rp100,000",
        argoClass = "Eksekutif",
        ticketRemaining = 10
    ),
    Ticket(
        argo = "Argo Wilis",
        startLeaving = "09:00",
        arrive = "11:30",
        estimatedTime = "2 jam 30 menit",
        price = "Rp90,000",
        argoClass = "Bisnis",
        ticketRemaining = 5
    ),
    Ticket(
        argo = "Argo Parahyangan",
        startLeaving = "12:00",
        arrive = "14:30",
        estimatedTime = "2 jam 30 menit",
        price = "Rp80,000",
        argoClass = "Ekonomi",
        ticketRemaining = 8
    ),
    Ticket(
        argo = "Argo Lawu",
        startLeaving = "15:00",
        arrive = "17:30",
        estimatedTime = "2 jam 30 menit",
        price = "Rp95,000",
        argoClass = "Bisnis",
        ticketRemaining = 12
    ),
    Ticket(
        argo = "Argo Dwipangga",
        startLeaving = "18:00",
        arrive = "20:30",
        estimatedTime = "2 jam 30 menit",
        price = "Rp110,000",
        argoClass = "Eksekutif",
        ticketRemaining = 7
    ),
    Ticket(
        argo = "Argo Sindoro",
        startLeaving = "21:00",
        arrive = "23:30",
        estimatedTime = "2 jam 30 menit",
        price = "Rp85,000",
        argoClass = "Ekonomi",
        ticketRemaining = 3
    )
)
