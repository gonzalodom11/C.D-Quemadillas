import matplotlib.pyplot as plt
import numpy as np
def graphVictories():
    
    # create data
    x = ['Cobos', 'Hugo', 'Manosalva', 'Albertosi', 'Manuel \n del Rosal']
    y1 = [58, 51, 48, 46, 41]
    y2 = [29, 29, 27, 29, 18]

    # set width of bar
    bar_width = 0.35

    # set x positions of bars
    r1 = np.arange(len(y1))
    r2 = [x + bar_width for x in r1]

    # create bar chart
    plt.bar(r1, y1, color='blue', width=bar_width, edgecolor='white', label='Puntos')
    plt.bar(r2, y2, color='orange', width=bar_width, edgecolor='white', label='Partidos')

    # add labels and title
    #plt.ylabel('Values')
    plt.title('Puntos y partidos jugados')

    # add x-axis ticks and labels
    plt.xticks([r + bar_width/2 for r in range(len(y1))], x)

    # add legend
    plt.legend()

    # show chart
    plt.show()

graphVictories()